/**
 * \file
 * Defines the strings class.
 *
 * \author Alessandro Antonello <aantonello@paralaxe.com.br>
 * \date   agosto 26, 2013
 * \since  Simple Framework 2.5
 * \version 1.0
 *
 * \par License
 * Apache v2 License.
 */
package sf.lang;

/**
 * \ingroup sf_lang
 * Helper class to work with character strings.
 * All functions accept \b null strings. That is, it is safe to pass an
 * invalid \c String object in all functions. No exception will be thrown.
 * Check the documentation of the function to know what it will do when a \b
 * null string is passed.
 *//* --------------------------------------------------------------------- */
public final class strings
{
    /** \name Constants */ //@{
    public static final String EMPTY = "";  /**< An empty string constant.  */
    //@}

    /** \name Information */ //@{
    // public static int     length(String s);/*{{{*/
    /**
     * Gets the length of a \b String object.
     * \param s String to get its length, in characters.
     * \return The length of the string \a s or zero, if \a s is \b null or
     * empty.
     **/
    public static int length(String s) {
        return ((s == null) ? 0 : s.length());
    }/*}}}*/
    // public static boolean isHexChar(char c);/*{{{*/
    /**
     * Check if a character can represent an hexadecimal number.
     * \param c The character to check.
     * \return \b true if the character represents an hexadecimal number.
     * Otherwise \b false.
     **/
    public static boolean isHexChar(char c) {
        return ("0123456789ABCDEFabcdef".indexOf(c) >= 0);
    }/*}}}*/
    // public static boolean isDecimal(char c);/*{{{*/
    /**
     * Check if the character can represent a decimal number.
     * \param c The character to check.
     * \return \b true if the character represents an decimal number.
     * Otherwise \b false.
     **/
    public static boolean isDecimal(char c) {
        return ("0123456789".indexOf(c) >= 0);
    }/*}}}*/
    // public static boolean isOctal(char c);/*{{{*/
    /**
     * Check if the character can represent an octal number.
     * \param c The character to check.
     * \return \b true if the character represents an octal number.
     * Otherwise \b false.
     **/
    public static boolean isOctal(char c) {
        return ("01234567".indexOf(c) >= 0);
    }/*}}}*/
    //@}

    /** \name Convertion to Number */ //@{
    // public static int    toInt(String num, int radix);/*{{{*/
    /**
     * Converts a string to a number using the given radix.
     * \param num The string with the number. Leading and/or trailing white
     * spaces will be removed.
     * \param radix The radix to do the conversion. This must be 0 or in range
     * 2-36. If this value is 0 the function will try to recognize the radix
     * from the string. If the string starts with '0x' or '0X' radix 16 will
     * be used (hex number). If the string starts with '0' radix 8 will be
     * used (octal number). If the string starts with a character from '1' to
     * '9' radix 10 will be used (decimal number).
     * \return The \b int value result of the string conversion.
     * \remarks The function supports that the string has a signal. That is,
     * the value can have a minus '-' or plus '+' signal in front of it. The
     * conversion will stop in the first invalid character. No error or
     * exception will be thrown.
     **/
    public static int toInt(String num, int radix) {
        return (int)(strings.toLong(num, radix) & 0x00000000FFFFFFFF);
    }/*}}}*/
    // public static long   toLong(String num, int radix);/*{{{*/
    /**
     * Converts a string to a number using the given radix.
     * \param num The string with the number. Any leading or trailing white
     * spaces are removed.
     * \param radix The radix to do the conversion. This must be 0 or in range
     * 2-36. If this value is 0 the function will try to recognize the radix
     * from the string. If the string starts with '0x' or '0X' radix 16 will
     * be used (hex number). If the string starts with '0' radix 8 will be
     * used (octal number). If the string starts with a character from '1' to
     * '9' radix 10 will be used (decimal number).
     * \return The \b long value result of the string conversion.
     * \remarks The function supports that the string has a signal. That is,
     * the value can have a minus '-' or plus '+' signal in front of it. The
     * conversion will stop in the first invalid character. No error or
     * exception will be thrown. If \a num is \b null or zero length, the
     * result will be zero.
     **/
    public static long toLong(String num, int radix)
    {
        long result = 0L;

        if ((num == null) || (num.length() == 0)) {
            return result;
        }

        char[] arr = getChars(num.trim());
        char c;
        int   pos = 0;
        int count = arr.length;
        int   val = 0;
        boolean negative = false;

        while ((pos < count) && Character.isWhitespace(arr[pos])) {
            pos++;                  /* Skip white spaces. */
        }

        if (pos >= count) {
            return result;          /* Only spaces in the text. */
        }

        /* Check of a sign. */
        if (arr[pos] == '-') {
            pos++;
            negative = true;
        } else if (arr[pos] == '+') {
            pos++;
        }

        /* We always need to check about the end of the string. */
        if (pos >= count) return result;

        /* If radix is zero we need to figure out. */
        if (radix == 0) {
            if ((arr[pos] == '0') && (pos < (count - 1))) {
                if ((arr[pos+1] == 'x') || (arr[pos+1] == 'X'))
                    radix = 16;
                else
                    radix = 8;
            }
            else
                radix = 10;
        }

        /* Validating the 'radix' value. */
        if ((radix < 0) || (radix == 1) || (radix > 36)) {
            return result;
        } else if (radix == 16) {
            /* The text might have '0x' on it. We should remove it. */
            if ((arr[pos] == '0') && (pos < (count - 1))) {
                if ((arr[pos+1] == 'x') || (arr[pos+1] == 'X'))
                    pos += 2;
            }
        }

        while (pos < count) {
            c = arr[pos++];

            if (Character.isDigit(c))
                val = Character.digit(c, 10);
            else if (Character.isLetter(c))
                val = Character.digit(c, 16);
            else
                break;                  /* Invalid char. */

            if (val >= radix) break;    /* Another invalid value. */
            result = result * radix + val;  /* NOTE: possibility of ArithmeticException. */
        }

        /* End of the conversion. Negate the number if we found a sign. */
        return (negative ? -result : result);
    }/*}}}*/
    // public static float  toFloat(String num);/*{{{*/
    /**
     * Converts a string to a float value.
     * \param num The string to be converted. Leading and trailing white
     * spaces are ignored. The string can have any valid \c Float value
     * representantion, including hexadecimal and/or signalied expoent.
     * \return A float value result of the string convertion. If the string
     * doesn't represent a valid float value the return will be zero.
     **/
    public static float  toFloat(String num) {
        try { return Float.parseFloat(num); }
        catch (Exception ex) { /* we will ignore this for while. */ }
        return .0F;
    }/*}}}*/
    //@}

    /** \name Convertion to Character Array */ //@{
    // public static char[] getChars(String s);/*{{{*/
    /**
     * Gets an array of characters for this string.
     * \param s The string to convert in a character array.
     * \return An array of chars.
     * \see getChars(String,int,int)
     **/
    public static char[] getChars(String s) {
        return strings.getChars(s, 0, -1);
    }/*}}}*/
    // public static char[] getChars(String s, int start, int count);/*{{{*/
    /**
     * Gets an array of characters from a substring of \a s.
     * \param s The string to get the characters.
     * \param start The starting index of the source \a s.
     * \param count Total number of characters to convert. If less than zero
     * the total length of the string, starting at \a start, is converted.
     * \return The array of characters.
     * \remarks When \a s is null or zero length, the result will be \b null.
     * If the final position (start + count) is greater than the total length
     * of the string, only the available characters are returned. When \a
     * start is invalid (out side the bounds of the string) the result will
     * also be \b null.
     **/
    public static char[] getChars(String s, int start, int count)
    {
        int limit = strings.length(s);
        if (limit == 0) return null;
        if ((start < 0) || (start >= limit)) return null;
        if ((count < 0) || ((start + count) > limit)) {
            count = limit - start;
        }
        char[] result = new char[count];
        try { s.getChars(start, count, result, 0); }
        catch (Exception ex) { result = null; }
        return result;
    }/*}}}*/
    //@}

    /** \name Convertion to Byte Array */ //@{
    // public static byte[] encode(String text, String enc);/*{{{*/
    /**
     * Encode a string into a byte array using the specified encoding.
     * \param text The string to convert in a byte array.
     * \param enc The encoding to encode the string into the byte array.
     * \return The result array on success. \b null if some error occurs.
     * \sa ENC
     **/
    public static byte[] encode(String text, String enc)
    {
        if ((length(text) == 0) || (length(enc) == 0))
            return null;

        byte[] array;
        try { array = text.getBytes(enc); }
        catch (Exception ex) {
            return null;
        }
        return array;
    }/*}}}*/
    // public static byte[] encode(String text, String enc, int len);/*{{{*/
    /**
     * Encode a string into a byte array using the specified encoding.
     * \param text The string to convert in a byte array.
     * \param enc The encoding to encode the string into the byte array.
     * \param len The length for the resulting array. This is useful
     * when encoding a string to put in a binary file. The resulting array
     * will be padded or truncated to this number of elements. When padded,
     * the excess will be filled with zeroes.
     * \return The result array on success. If an error occurs the resulting
     * array will be filled with zeroes.
     * \sa ENC
     **/
    public static byte[] encode(String text, String enc, int len)
    {
        byte[] result = new byte[len];
        byte[] array  = encode(text, enc);

        arrays.set(result, (byte)0, 0, -1);
        if (array == null) return result;

        int limit = Math.min(len, array.length);
        arrays.copy(result, 0, array, 0, limit);
        return result;
    }/*}}}*/
    //@}

    /** \name Operations */ //@{
    // public static String substr (String str, int start, int len);/*{{{*/
    /**
     * Gets a sub-string of the given string.
     * \param str String to extract the sub-string.
     * \param start Zero based index of the starting character to extract.
     * \param len Length of the sub-string. If less than zero all characters
     * starting from \a start will be extracted.
     * \returns A string resulting the extracted sub-string or \b null if no
     * sub-string could be extracted.
     **/
    public static String substr(String str, int start, int len)
    {
        if ((str == null) || (start < 0) || (len == 0))
            return null;

        if (len < 0) len = (str.length() - start);

        try { return str.substring(start, (len + start)); }
        catch (Exception ex) {
            /* Ignoring errors in this operation. */
        }
        return null;
    }/*}}}*/
    // public static String replace(String str, String rem, String add);/*{{{*/
    /**
     * Replaces a sub-string with another string value.
     * \param str The original string, where the substitution must be done.
     * \param rem The string to be removed from the original \a str string.
     * \param add The string to be added in the place where \a rem string was.
     * \return The new string with the substitution done. If the \a rem string
     * isn't found the original \a str string will be returned without
     * changes.
     * \remarks All occurrences of \a rem will be replaced with \a add. \a add
     * can be \b null. In this case all occurrences of \a rem will be removed.
     **/
    public static String replace(String str, String rem, String add)
    {
        if ((length(str) == 0) || (length(rem) == 0))
            return str;

        int index = str.indexOf(rem);
        int count = strings.length(rem);
        String start, end, added = (add == null ? EMPTY : add);

        while (index >= 0)
        {
            start = strings.substr(str, 0, index);
            end   = strings.substr(str, index + count, -1);

            str = ((start != null) ? start : strings.EMPTY) + added
                  + ((end != null) ? end : strings.EMPTY);

            index = str.indexOf(rem);
        }
        return str;
    }/*}}}*/
    // public static String sanitize(String str);/*{{{*/
    /**
     * Sanitizes the passed in String object.
     * Sanitize means make it as valid as possible. The function checks for a
     * \b null String converting it to the valid strings#EMPTY object. The
     * function also checks for the possible presence of unprintable
     * characters, removing them.
     * \param str String to sanitize.
     * \return The function assures that the return value is a printable
     * string or a zero length string. This function never returns \b null.
     **/
    public static String sanitize(String str)
    {
        if (strings.length(str) == 0) return EMPTY;

        char[] chars = strings.getChars(str);
        char[] letters = new char[ arrays.length(chars) ];
        int counter  = 0, limit = arrays.length(chars);

        for (int i = 0; i < limit; i++) {
            if (Character.isLetterOrDigit(chars[i]) || Character.isWhitespace(chars[i])) {
                letters[counter] = chars[i];
                counter++;
            }
        }

        if (counter == 0) return EMPTY;
        return new String(letters, 0, counter);
    }/*}}}*/
    // public static String repeat (char c, int times);/*{{{*/
    /**
     * Build a string by repeating a character.
     * \param c The character to repeat.
     * \param times Number of times to repeat the character \a c.
     * \return A string built of the character \a c repeated \a times times.
     * \remarks When \a time is equal to 0 an empty string will be returned.
     **/
    public static String repeat(char c, int times)
    {
        if (times == 0) return strings.EMPTY;
        char[] array = new char[times];
        arrays.set(array, c, 0, -1);
        return new String(array);
    }/*}}}*/
    // public static String repeat (String s, int times);/*{{{*/
    /**
     * Builds a string by repeating another string.
     * \param s The string to be repeated.
     * \param times Number of times to repeat the string \a s.
     * \return A new String object built of the repetition of the string passed
     * through \a s.
     * \remarks When \a times is equal to zero an empty string will be
     * returned.
     **/
    public static String repeat (String s, int times)
    {
        if ((times == 0) || (length(s) == 0)) return strings.EMPTY;
        String[] vector = new String[times];
        arrays.set(vector, s, 0, -1);
        return arrays.join(vector, null);
    }/*}}}*/
    //@}

    /** \name Search Operations */ //@{
    // public static int     search (String str, String...list);/*{{{*/
    /**
     * Searches for the first occurrence of \a str in a list of strings.
     * \param str String to each of.
     * \param list List of strings to search for \a str.
     * \return The zero based index of the item in the \a list where \a str
     * was found. Otherwise the function returns -1. The comparison is case
     * insensitive.
     **/
    public static int search(String str, String...list)
    {
        if ((str == null) || (list == null) || (list.length == 0))
            return -1;

        int limit = list.length;

        for (int i = 0; i < limit; i++) {
            if (str.equalsIgnoreCase(list[i]))
                return i;
        }
        return -1;
    }/*}}}*/
    // public static boolean startsWith(String str, String prefix);/*{{{*/
    /**
     * Checks if \a str starts with \a prefix.
     * @param str String where \a prefix may occur.
     * @param prefix String in the beginning of \a str.
     * @return \b true if \a str starts with \a prefix. Otherwise \b false.
     * The function also returns \b false if one or more of its parameters are
     * \b null or zero length strings.
     * @note The comparison is case sensitive.
     * @since 2.5
     **/
    public static boolean startsWith(String str, String prefix)
    {
        if ((length(str) == 0) || (length(prefix) == 0))
            return false;

        try { return str.startsWith(prefix); }
        catch (Exception ex) { /* Ignored exception. */ }

        return false;
    }/*}}}*/
    // public static boolean endsWith(String str, String suffix);/*{{{*/
    /**
     * Checks if \a str ends with \a suffix.
     * @param str String where \a suffix may occur.
     * @param suffix String in the end of \a str.
     * @return \b true if \a str ends with \a suffix. Otherwise \b false.
     * The function also returns \b false if one or more of its parameters are
     * \b null or zero length strings.
     * @note The comparison is case sensitive.
     * @since 2.5
     **/
    public static boolean endsWith(String str, String suffix)
    {
        if ((length(str) == 0) || (length(suffix) == 0))
            return false;

        try { return str.endsWith(suffix); }
        catch (Exception ex) { /* Ignored exception. */ }

        return false;
    }/*}}}*/
    // public static String  pathTail(String path);/*{{{*/
    /**
     * Returns the last component of a path or URL.
     * @param path String with path or URL which with the last component will
     * be returned. If this argument is \b null, the result will be an empty
     * string (\c EMPTY).
     * @return A string with the last component of the passed \a path.
     * @remarks This function does not check if the path if valid. Also does
     * not differentiate files from directories. The operation is done solely
     * in the passed string.
     *
     * Path separators must be forward slashes. Back slashes are not
     * recognized. If you are on Windows you can use the #replace() method to
     * change back slashes into forward slashes.
     * @par Examples
     * <pre>
     * String item = strings.pathTail("directory/name/file.ext");
     * // item = "file.ext"
     * item = strings.pathTail("directory/name/");
     * // item = "name"
     * item = strings.pathTail("directory");
     * // item = "directory"
     * item = strings.pathTail(strings.replace("C:\\file", "\\", "/"));
     * // item = "file"
     * </pre>
     * @since 2.5
     **/
    public static String pathTail(String path)
    {
        if (length(path) == 0) return strings.EMPTY;

        int index = path.lastIndexOf('/', (path.length() - 2));
        if (index < 0) return path;

        return strings.substr(path, (index + 1), -1);
    }/*}}}*/
    //@}
}
// vim:syntax=java.doxygen
