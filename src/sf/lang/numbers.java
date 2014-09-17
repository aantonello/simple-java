/**
 * \file
 * Defines the numbers class.
 *
 * \author Alessandro Antonello <aantonello@paralaxe.com.br>
 * \date   setembro 11, 2013
 * \since  Simple Framework 2.5
 * \version 2.0
 *
 * \par License
 * Apache v2 License.
 */
package sf.lang;

/**
 * \ingroup sf_lang
 * A static class to work with numbers.
 * At most this class has methods to pack high words and low words of numeric
 * values or put it then together again. Also this class offers reverse the
 * byte order of numerical values easy.
 *
 * One of the things that I miss in Java is the hability to use unsigned
 * numbers. Becouse of this the \c numbers class has some methods to convert
 * \b byte to \b short, \b short to \b int and \b int to \b long that always
 * return positive values, regardless of the signal of the original value.
 *//* --------------------------------------------------------------------- */
public final class numbers
{
    /** \name Reverse Order */ //@{
    // public static short reverse(short number);/*{{{*/
    /**
     * Reverses the order of bytes in a number.
     * \param number The number to reverse the byte order. A Little-Endian
     * number will become a Big-Endian and vice-versa.
     * \return The number with the byte order reversed.
     **/
    public static short reverse(short number) {
        return Short.reverseBytes(number);
    }/*}}}*/
    // public static int   reverse(int number);/*{{{*/
    /**
     * @copydoc reverse(short)
     **/
    public static int reverse(int number) {
        return Integer.reverseBytes(number);
    }/*}}}*/
    // public static long  reverse(long number);/*{{{*/
    /**
     * @copydoc reverse(short)
     **/
    public static long reverse(long number) {
        return Long.reverseBytes(number);
    }/*}}}*/
    //@}

    /** \name Low/High Spliting */ //@{
    // public static int  lo_bits (byte number);/*{{{*/
    /**
     * Extract the low order bits of a byte value.
     * \param number Number to extract the low order bits. As Java default
     * Big-Endianess, the four low orde bits are the last ones.
     * \return An \b int number with only the low order bits of the \a number
     * value.
     **/
    public static int lo_bits(byte number) {
        return (number & 0x0F);
    }/*}}}*/
    // public static int  hi_bits (byte number);/*{{{*/
    /**
     * Extracts the high order bits of a byte number.
     * \param number Number to extract the high order bits. As Java default
     * Big-Endianess, the four high orde bits are the first ones.
     * \return An \b int number with only the high order bits of the \a number
     * value.
     **/
    public static int hi_bits(byte number) {
        return ((number >> 4) & 0x0F);
    }/*}}}*/
    // public static int  lo_byte (short number);/*{{{*/
    /**
     * Extracts the low order byte of a short number.
     * \param number The number to extract the low order byte.
     * \returns An \b int with the low order byte value of the short number.
     **/
    public static int lo_byte(short number) {
        return (number & 0x00FF);
    }/*}}}*/
    // public static int  hi_byte (short number);/*{{{*/
    /**
     * Extracts the high order byte of a short number.
     * \param number A short number to extract the high order byte value.
     * \returns An \b int number with the high order byte value of the passed
     * short number.
     **/
    public static int hi_byte(short number) {
        return ((number >> 8) & 0x00FF);
    }/*}}}*/
    // public static int  lo_word (int  number);/*{{{*/
    /**
     * Extracts the low order word of an int number.
     * \param number An int number to extract the low order word. A \b word is
     * a 16 bit value.
     * \returns An \b int with the low order word value of the int number.
     **/
    public static int lo_word(int number) {
        return (number & 0x0000FFFF);
    }/*}}}*/
    // public static int  hi_word (int  number);/*{{{*/
    /**
     * Extracts the high order word of an int number.
     * \param number An int number to extract the high order word. A \b word is
     * a 16 bit value.
     * \returns An \b int with the high order word value of the int number.
     **/
    public static int hi_word(int number) {
        return ((number >> 16) & 0x0000FFFF);
    }/*}}}*/
    // public static long lo_dword(long number);/*{{{*/
    /**
     * Extrats the low order double word of a long number.
     * \param number Long number to extract the low order double word. A
     * double word (\b dword) is a 32 bits value.
     * \returns The low order 32 bits value of the number.
     **/
    public static long lo_dword(long number) {
        return (number & 0x00000000FFFFFFFF);
    }/*}}}*/
    // public static long hi_dword(long number);/*{{{*/
    /**
     * Extrats the high order double word of a long number.
     * \param number Long number to extract the high order double word. A
     * double word (\b dword) is a 32 bits value.
     * \returns The high order 32 bits value of the number.
     **/
    public static long hi_dword(long number) {
        return ((number >> 32) & 0x00000000FFFFFFFF);
    }/*}}}*/
    //@}

    /** \name Low/High Joining */ //@{
    // public static byte  make_byte (int high_bits, int low_bits);/*{{{*/
    /**
     * Builds a new byte number from two 4 bits separated values.
     * \param high_bits Value for the high order bits of the number.
     * \param low_bits Value for the low order bits of the number.
     * \returns The new \b byte number created. Big-Endian.
     **/
    public static byte make_byte(int high_bits, int low_bits) {
        return (byte)(((high_bits & 0x0F) << 4) | (low_bits & 0x0F));
    }/*}}}*/
    // public static short make_word (int high_byte, int low_byte);/*{{{*/
    /**
     * Builds a new word number from two byte values.
     * \param high_byte Value for the high order byte of the word.
     * \param low_byte Value for the low order byte of the word.
     * \returns A new \b short value built from the two byte values.
     * Big-Endian.
     **/
    public static short make_word(int high_byte, int low_byte) {
        return (short)(((high_byte & 0x00FF) << 16) | (low_byte & 0x00FF));
    }/*}}}*/
    // public static int   make_dword(int high_word, int low_word);/*{{{*/
    /**
     * Builds a new double word number from two word values.
     * \param high_word Value for the high order word of the number.
     * \param low_word Value for the low order word of the number.
     * \returns The new \b int number create. Big-Endian.
     **/
    public static int make_dword(int high_word, int low_word) {
        return (((high_word & 0x0000FFFF) << 16) | (low_word & 0x0000FFFF));
    }/*}}}*/
    // public static long  make_qword(int high_dword, int low_dword);/*{{{*/
    /**
     * Builds a quad word numbe from two double word values.
     * \param high_dword Value for the high order double word of the number.
     * \param low_dword Value for the low order double word of the number.
     * \returns A \b long number built with the two values. Big-Endian.
     **/
    public static long make_qword(int high_dword, int low_dword) {
        return (((high_dword & 0x00000000FFFFFFFF) << 32) | (low_dword & 0x00000000FFFFFFFF));
    }/*}}}*/
    //@}

    /** \name Values Casting */ //@{
    // public static short int8_to16(byte value);/*{{{*/
    /**
     * Casts an 8 bits value to 16 bits, unsigned.
     * \param value byte value to cast.
     * \returns The \b short number result of the cast.
     **/
    public static short int8_to16(byte value) {
        return (short)(value & 0x000000FF);
    }/*}}}*/
    // public static int   int8_to32(byte value);/*{{{*/
    /**
     * Casts an 8 bits value to 32 bits, unsigned.
     * \param value byte value to cast.
     * \returns The \b int number result of the cast.
     **/
    public static int   int8_to32(byte value) {
        return (value & 0x000000FF);
    }/*}}}*/
    // public static long  int8_to64(byte value);/*{{{*/
    /**
     * Casts an 8 bits value to 64 bits, unsigned.
     * \param value byte value to cast.
     * \returns The \b long number result of the cast.
     **/
    public static long  int8_to64(byte value) {
        return (value & 0x00000000000000FF);
    }/*}}}*/
    // public static int  int16_to32(short value);/*{{{*/
    /**
     * Casts a 16 bits value to 32 bits, unsigned.
     * \param value short value to cast.
     * \returns The \b int number result of the cast.
     **/
    public static int int16_to32(short value) {
        return (value & 0x0000FFFF);
    }/*}}}*/
    // public static long int16_to64(short value);/*{{{*/
    /**
     * Casts a 16 bits value to 64 bits, unsigned.
     * \param value short value to cast.
     * \returns The \b long number result of the cast.
     **/
    public static long int16_to64(short value) {
        return (value & 0x000000000000FFFF);
    }/*}}}*/
    // public static long int32_to64(int  value);/*{{{*/
    /**
     * Casts a 32 bits value into 64 bits, unsigned.
     * \param value int value to cast.
     * \returns The \b long number result of the cast.
     **/
    public static long int32_to64(int  value) {
        return (value & 0x00000000FFFFFFFF);
    }/*}}}*/
    //@}
}
// vim:syntax=java.doxygen
