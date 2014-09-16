/**
 * \file
 * Defines the arrays class.
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

import java.util.Random;
import java.lang.reflect.Array;

/**
 * Static class to help work with arrays of integral types.
 * The more change in this class is the use of generics for methods.
 *//* --------------------------------------------------------------------- */
public final class arrays
{
    /** \name Arrays Length */ //@{
    // public static int length(byte[] array);/*{{{*/
    /**
     * Returns the length of an array in a safe way.
     * \param array The array to get the length of.
     * \return The current number of elements in the array or 0 if the object
     * is \b null.
     **/
    public static int length(byte[] array) {
        return ((array != null) ? array.length : 0);
    }/*}}}*/
    // public static int length(char[] array);/*{{{*/
    /**
     * @copydoc length(byte[])
     **/
    public static int length(char[] array) {
        return ((array != null) ? array.length : 0);
    }/*}}}*/
    // public static int length(short[] array);/*{{{*/
    /**
     * @copydoc length(byte[])
     **/
    public static int length(short[] array) {
        return ((array != null) ? array.length : 0);
    }/*}}}*/
    // public static int length(int[] array);/*{{{*/
    /**
     * @copydoc length(byte[])
     **/
    public static int length(int[] array) {
        return ((array != null) ? array.length : 0);
    }/*}}}*/
    // public static int length(long[] array);/*{{{*/
    /**
     * @copydoc length(byte[])
     **/
    public static int length(long[] array) {
        return ((array != null) ? array.length : 0);
    }/*}}}*/
    // public static <T> int length(T [] array);/*{{{*/
    /**
     * @copydoc length(byte[])
     **/
    public static <T> int length(T [] array) {
        return ((array != null) ? array.length : 0);
    }/*}}}*/
    //@}

    /** \name Fills an Array */ //@{
    // public static int set(byte[] array, byte value, int start, int count);/*{{{*/
    /**
     * Fills a portion of an array with the specified value.
     * \param array The array to be filled.
     * \param value Value to fill the portion of \a array.
     * \param start Postion where the filling should start. If less than zero
     * the operation will fail.
     * \param count Number of elemento to be filled starting from \a start. If
     * this argument is zero no elements will be filled. If it is less than
     * zero all elements starting from \a start until the end of the array
     * will be set with \a value value.
     * \return The number of elements filled by the function.
     **/
    public static int set(byte[] array, byte value, int start, int count)
    {
        int size = arrays.length(array);
        if ((start < 0) || (start >= size)) return 0;
        if (count < 0) count = (size - start);

        size = start + count;
        for (int i = 0; i < size; i++) {
            array[i] = value;
        }
        return count;
    }/*}}}*/
    // public static int set(char[] array, char value, int start, int count);/*{{{*/
    /**
     * @copydoc set(byte[],byte,int,int)
     **/
    public static int set(char[] array, char value, int start, int count)
    {
        int size = arrays.length(array);
        if ((start < 0) || (start >= size)) return 0;
        if (count < 0) count = (size - start);

        size = start + count;
        for (int i = 0; i < size; i++) {
            array[i] = value;
        }
        return count;
    }/*}}}*/
    // public static int set(short[] array, short value, int start, int count);/*{{{*/
    /**
     * @copydoc set(byte[],byte,int,int)
     **/
    public static int set(short[] array, short value, int start, int count)
    {
        int size = arrays.length(array);
        if ((start < 0) || (start >= size)) return 0;
        if (count < 0) count = (size - start);

        size = start + count;
        for (int i = 0; i < size; i++) {
            array[i] = value;
        }
        return count;
    }/*}}}*/
    // public static int set(int [] array, int  value, int start, int count);/*{{{*/
    /**
     * @copydoc set(byte[],byte,int,int)
     **/
    public static int set(int [] array, int  value, int start, int count)
    {
        int size = arrays.length(array);
        if ((start < 0) || (start >= size)) return 0;
        if (count < 0) count = (size - start);

        size = start + count;
        for (int i = 0; i < size; i++) {
            array[i] = value;
        }
        return count;
    }/*}}}*/
    // public static int set(long[] array, long value, int start, int count);/*{{{*/
    /**
     * @copydoc set(byte[],byte,int,int)
     **/
    public static int set(long[] array, long value, int start, int count)
    {
        int size = arrays.length(array);
        if ((start < 0) || (start >= size)) return 0;
        if (count < 0) count = (size - start);

        size = start + count;
        for (int i = 0; i < size; i++) {
            array[i] = value;
        }
        return count;
    }/*}}}*/
    // public static <T> int set(T[] array, T value, int start, int count);/*{{{*/
    /**
     * @copydoc set(byte[],byte,int,int)
     **/
    public static <T> int set(T[] array, T value, int start, int count)
    {
        int size = arrays.length(array);
        if ((start < 0) || (start >= size)) return 0;
        if (count < 0) count = (size - start);

        size = start + count;
        for (int i = 0; i < size; i++) {
            array[i] = value;
        }
        return count;
    }/*}}}*/
    //@}

    /** \name Copy from Array to Array */ //@{
    // public static int copy(byte[] dest, int destStart, byte[] src, int srcStart, int count);/*{{{*/
    /**
     * Copies data from one array to another.
     * \param dest The destination array.
     * \param destStart The index where the copy should start override the
     * destination elements. If less than zero the function will fails.
     * \param src The source array.
     * \param srcStart The position on the \a src array to start copying
     * elements. If less than zero the function will fails.
     * \param count Number of elements to copy from \a src to \a dest. If this
     * value is zero nothing will be copyied and the result will be zero. If
     * less than zero the function will copy all values from \a src, starting
     * from \a srcStart until the length of \a src of the length of \a dest,
     * which comes first.
     * \return The number of elements on \a dest that was overwritten by the
     * copy operation.
     * \remarks \a src and \a dest cannot be the same array. Use \c
     * arrays::move() when you need to move data within the same array.
     **/
    public static int copy(byte[] dest, int destStart, byte[] src, int srcStart, int count)
    {
        int srcLimit = arrays.length(src);
        int dstLimit = arrays.length(dest);

        if ((destStart < 0) || (destStart >= srcLimit)) return 0;
        if ((srcStart < 0) || (srcStart >= dstLimit)) return 0;
        if (count < 0) count = (srcLimit - srcStart);
        if (count > (dstLimit - destStart)) count = (dstLimit - destStart);

        for (int i = 0; i < count; i++) {
            dest[destStart + i] = src[srcStart + i];
        }
        return count;
    }/*}}}*/
    // public static int copy(char[] dest, int destStart, char[] src, int srcStart, int count);/*{{{*/
    /**
     * @copydoc copy(byte[],int,byte[],int,int)
     **/
    public static int copy(char[] dest, int destStart, char[] src, int srcStart, int count)
    {
        int srcLimit = arrays.length(src);
        int dstLimit = arrays.length(dest);

        if ((destStart < 0) || (destStart >= srcLimit)) return 0;
        if ((srcStart < 0) || (srcStart >= dstLimit)) return 0;
        if (count < 0) count = (srcLimit - srcStart);
        if (count > (dstLimit - destStart)) count = (dstLimit - destStart);

        for (int i = 0; i < count; i++) {
            dest[destStart + i] = src[srcStart + i];
        }
        return count;
    }/*}}}*/
    // public static int copy(short[] dest, int destStart, short[] src, int srcStart, int count);/*{{{*/
    /**
     * @copydoc copy(byte[],int,byte[],int,int)
     **/
    public static int copy(short[] dest, int destStart, short[] src, int srcStart, int count)
    {
        int srcLimit = arrays.length(src);
        int dstLimit = arrays.length(dest);

        if ((destStart < 0) || (destStart >= srcLimit)) return 0;
        if ((srcStart < 0) || (srcStart >= dstLimit)) return 0;
        if (count < 0) count = (srcLimit - srcStart);
        if (count > (dstLimit - destStart)) count = (dstLimit - destStart);

        for (int i = 0; i < count; i++) {
            dest[destStart + i] = src[srcStart + i];
        }
        return count;
    }/*}}}*/
    // public static int copy(int [] dest, int destStart, int [] src, int srcStart, int count);/*{{{*/
    /**
     * @copydoc copy(byte[],int,byte[],int,int)
     **/
    public static int copy(int [] dest, int destStart, int [] src, int srcStart, int count)
    {
        int srcLimit = arrays.length(src);
        int dstLimit = arrays.length(dest);

        if ((destStart < 0) || (destStart >= srcLimit)) return 0;
        if ((srcStart < 0) || (srcStart >= dstLimit)) return 0;
        if (count < 0) count = (srcLimit - srcStart);
        if (count > (dstLimit - destStart)) count = (dstLimit - destStart);

        for (int i = 0; i < count; i++) {
            dest[destStart + i] = src[srcStart + i];
        }
        return count;
    }/*}}}*/
    // public static int copy(long[] dest, int destStart, long[] src, int srcStart, int count);/*{{{*/
    /**
     * @copydoc copy(byte[],int,byte[],int,int)
     **/
    public static int copy(long[] dest, int destStart, long[] src, int srcStart, int count)
    {
        int srcLimit = arrays.length(src);
        int dstLimit = arrays.length(dest);

        if ((destStart < 0) || (destStart >= srcLimit)) return 0;
        if ((srcStart < 0) || (srcStart >= dstLimit)) return 0;
        if (count < 0) count = (srcLimit - srcStart);
        if (count > (dstLimit - destStart)) count = (dstLimit - destStart);

        for (int i = 0; i < count; i++) {
            dest[destStart + i] = src[srcStart + i];
        }
        return count;
    }/*}}}*/
    // public static <T> int copy(T[] dest, int destStart, T[] src, int srcStart, int count);/*{{{*/
    /**
     * @copydoc copy(byte[],int,byte[],int,int)
     **/
    public static <T> int copy(T[] dest, int destStart, T[] src, int srcStart, int count)
    {
        int srcLimit = arrays.length(src);
        int dstLimit = arrays.length(dest);

        if ((destStart < 0) || (destStart >= srcLimit)) return 0;
        if ((srcStart < 0) || (srcStart >= dstLimit)) return 0;
        if (count < 0) count = (srcLimit - srcStart);
        if (count > (dstLimit - destStart)) count = (dstLimit - destStart);

        for (int i = 0; i < count; i++) {
            dest[destStart + i] = src[srcStart + i];
        }
        return count;
    }/*}}}*/
    //@}

    /** \name Moving from Array to Array */ //@{
    // public static int move(byte[] dest, int dstStart, byte[] src, int srcStart, int count);/*{{{*/
    /**
     * Copies data from one array to another.
     * \param dest The destination array.
     * \param destStart The index where the copy should start overwrite the
     * destination elements. If less than zero the function will fails.
     * \param src The source array.
     * \param srcStart The position on the \a src array to start copying
     * elements. If less than zero the function will fails.
     * \param count Number of elements to copy from \a src to \a dest. If this
     * value is zero nothing will be copyied and the result will be zero. If
     * less than zero the function will copy all values from \a src, starting
     * from \a srcStart until the length of \a src of the length of \a dest,
     * which comes first.
     * \return The number of elements on \a dest that was overwritten by the
     * copy operation.
     * \remarks \a src and \a dest arrays can be the same array. Indexes can
     * overllap.
     **/
    public static int move(byte[] dest, int dstStart, byte[] src, int srcStart, int count)
    {
        if ((dest != src) || (dstStart < srcStart))
            return arrays.copy(dest, dstStart, src, srcStart, count);

        int srcLimit = arrays.length(src);
        int dstLimit = arrays.length(dest);

        if ((dstStart < 0) || (dstStart >= srcLimit)) return 0;
        if ((srcStart < 0) || (srcStart >= dstLimit)) return 0;
        if (count < 0) count = (srcLimit - srcStart);
        if (count > (dstLimit - dstStart)) count = (dstLimit - dstStart);
        dstLimit = count;

        while (--count >= 0) {
            dest[dstStart + count] = src[srcStart + count];
        }
        return dstLimit;
    }/*}}}*/
    // public static int move(char[] dest, int dstStart, char[] src, int srcStart, int count);/*{{{*/
    /**
     * @copydoc move(byte[],int,byte[],int,int)
     **/
    public static int move(char[] dest, int dstStart, char[] src, int srcStart, int count)
    {
        if ((dest != src) || (dstStart < srcStart))
            return arrays.copy(dest, dstStart, src, srcStart, count);

        int srcLimit = arrays.length(src);
        int dstLimit = arrays.length(dest);

        if ((dstStart < 0) || (dstStart >= srcLimit)) return 0;
        if ((srcStart < 0) || (srcStart >= dstLimit)) return 0;
        if (count < 0) count = (srcLimit - srcStart);
        if (count > (dstLimit - dstStart)) count = (dstLimit - dstStart);
        dstLimit = count;

        while (--count >= 0) {
            dest[dstStart + count] = src[srcStart + count];
        }
        return dstLimit;
    }/*}}}*/
    // public static int move(short[] dest, int dstStart, short[] src, int srcStart, int count);/*{{{*/
    /**
     * @copydoc move(byte[],int,byte[],int,int)
     **/
    public static int move(short[] dest, int dstStart, short[] src, int srcStart, int count)
    {
        if ((dest != src) || (dstStart < srcStart))
            return arrays.copy(dest, dstStart, src, srcStart, count);

        int srcLimit = arrays.length(src);
        int dstLimit = arrays.length(dest);

        if ((dstStart < 0) || (dstStart >= srcLimit)) return 0;
        if ((srcStart < 0) || (srcStart >= dstLimit)) return 0;
        if (count < 0) count = (srcLimit - srcStart);
        if (count > (dstLimit - dstStart)) count = (dstLimit - dstStart);
        dstLimit = count;

        while (--count >= 0) {
            dest[dstStart + count] = src[srcStart + count];
        }
        return dstLimit;
    }/*}}}*/
    // public static int move(int [] dest, int dstStart, int [] src, int srcStart, int count);/*{{{*/
    /**
     * @copydoc move(byte[],int,byte[],int,int)
     **/
    public static int move(int [] dest, int dstStart, int [] src, int srcStart, int count)
    {
        if ((dest != src) || (dstStart < srcStart))
            return arrays.copy(dest, dstStart, src, srcStart, count);

        int srcLimit = arrays.length(src);
        int dstLimit = arrays.length(dest);

        if ((dstStart < 0) || (dstStart >= srcLimit)) return 0;
        if ((srcStart < 0) || (srcStart >= dstLimit)) return 0;
        if (count < 0) count = (srcLimit - srcStart);
        if (count > (dstLimit - dstStart)) count = (dstLimit - dstStart);
        dstLimit = count;

        while (--count >= 0) {
            dest[dstStart + count] = src[srcStart + count];
        }
        return dstLimit;
    }/*}}}*/
    // public static int move(long[] dest, int dstStart, long[] src, int srcStart, int count);/*{{{*/
    /**
     * @copydoc move(byte[],int,byte[],int,int)
     **/
    public static int move(long[] dest, int dstStart, long[] src, int srcStart, int count)
    {
        if ((dest != src) || (dstStart < srcStart))
            return arrays.copy(dest, dstStart, src, srcStart, count);

        int srcLimit = arrays.length(src);
        int dstLimit = arrays.length(dest);

        if ((dstStart < 0) || (dstStart >= srcLimit)) return 0;
        if ((srcStart < 0) || (srcStart >= dstLimit)) return 0;
        if (count < 0) count = (srcLimit - srcStart);
        if (count > (dstLimit - dstStart)) count = (dstLimit - dstStart);
        dstLimit = count;

        while (--count >= 0) {
            dest[dstStart + count] = src[srcStart + count];
        }
        return dstLimit;
    }/*}}}*/
    // public static <T> int move(T[] dest, int dstStart, T[] src, int srcStart, int count);/*{{{*/
    /**
     * @copydoc move(byte[],int,byte[],int,int)
     **/
    public static <T> int move(T[] dest, int dstStart, T[] src, int srcStart, int count)
    {
        if ((dest != src) || (dstStart < srcStart))
            return arrays.copy(dest, dstStart, src, srcStart, count);

        int srcLimit = arrays.length(src);
        int dstLimit = arrays.length(dest);

        if ((dstStart < 0) || (dstStart >= srcLimit)) return 0;
        if ((srcStart < 0) || (srcStart >= dstLimit)) return 0;
        if (count < 0) count = (srcLimit - srcStart);
        if (count > (dstLimit - dstStart)) count = (dstLimit - dstStart);
        dstLimit = count;

        while (--count >= 0) {
            dest[dstStart + count] = src[srcStart + count];
        }
        return dstLimit;
    }/*}}}*/
    //@}

    /** \name Reallocation */ //@{
    // public static byte[] realloc(byte[] array, int size);/*{{{*/
    /**
     * Reallocates (or allocates) array memory.
     * \param array Current array to be reallocated. Can be \b null.
     * \param size The new size for the array. If this is equals to or less
     * than zero the function returns \b null.
     * \return On success the function returns the new allocated array memory.
     * When the original array \a array is valid and has data, it will be
     * copied to the new allocated memory.
     **/
    public static byte[] realloc(byte[] array, int size)
    {
        if (size <= 0) return null;

        int count = arrays.length(array);
        byte[] temp  = new byte[size];

        if (temp == null) return array;
        if (array == null) return temp;

        arrays.copy(temp, 0, array, 0, ((size < count) ? size : count));
        return temp;
    }/*}}}*/
    // public static char[] realloc(char[] array, int size);/*{{{*/
    /**
     * @copydoc realloc(byte[],int)
     **/
    public static char[] realloc(char[] array, int size)
    {
        if (size <= 0) return null;

        int count = arrays.length(array);
        char[] temp  = new char[size];

        if (temp == null) return array;
        if (array == null) return temp;

        arrays.copy(temp, 0, array, 0, ((size < count) ? size : count));
        return temp;
    }/*}}}*/
    // public static short[] realloc(short[] array, int size);/*{{{*/
    /**
     * @copydoc realloc(byte[],int)
     **/
    public static short[] realloc(short[] array, int size)
    {
        if (size <= 0) return null;

        int count = arrays.length(array);
        short[] temp  = new short[size];

        if (temp == null) return array;
        if (array == null) return temp;

        arrays.copy(temp, 0, array, 0, ((size < count) ? size : count));
        return temp;
    }/*}}}*/
    // public static int[]  realloc(int[] array, int size);/*{{{*/
    /**
     * @copydoc realloc(byte[],int)
     **/
    public static int[]  realloc(int[] array, int size)
    {
        if (size <= 0) return null;

        int count = arrays.length(array);
        int[] temp  = new int[size];

        if (temp == null) return array;
        if (array == null) return temp;

        arrays.copy(temp, 0, array, 0, ((size < count) ? size : count));
        return temp;
    }/*}}}*/
    // public static long[] realloc(long[] array, int size);/*{{{*/
    /**
     * @copydoc realloc(byte[],int)
     **/
    public static long[] realloc(long[] array, int size)
    {
        if (size <= 0) return null;

        int count = arrays.length(array);
        long[] temp  = new long[size];

        if (temp == null) return array;
        if (array == null) return temp;

        arrays.copy(temp, 0, array, 0, ((size < count) ? size : count));
        return temp;
    }/*}}}*/
    // public static <T> T[] realloc(T[] array, int size);/*{{{*/
    /**
     * @copydoc realloc(byte[],int)
     **/
    public static <T> T[] realloc(T[] array, int size)
    {
        if (size <= 0) return null;

        int count = arrays.length(array);
        T[] temp = (T[])Array.newInstance(array.getClass().getComponentType(), size);

        if (temp == null) return array;
        if (array == null) return temp;

        arrays.copy(temp, 0, array, 0, ((size < count) ? size : count));
        return temp;
    }/*}}}*/
    //@}

    /** \name Insertion */ //@{
    // public static byte[] insert(byte[] dest, int position, byte value);/*{{{*/
    /**
     * Inserts a value into the specified position.
     * Memory for the array will be reallocated to create room for the new
     * value.
     * \param dest Destination array. Cannot be \b null.
     * \param position The position where the value should be inserted. Values
     * in the array, starting from this point, will be shifted so the new
     * value can be acomodated. If this value is less than zero or greater
     * than the length of the array \a dest, the value will be appended to the
     * array.
     * \param value Value to be inserted.
     * \return The new allocated array.
     **/
    public static byte[] insert(byte[] dest, int position, byte value)
    {
        if (dest == null) return null;

        int count = dest.length;
        dest = realloc(dest, count + 1);

        if ((position < 0) || (position >= count))
            position = count;
        else
            arrays.move(dest, (position+1), dest, position, (count - position));

        dest[position] = value;
        return dest;
    }/*}}}*/
    // public static char[] insert(char[] dest, int position, char value);/*{{{*/
    /**
     * @copydoc insert(byte[],int,byte)
     **/
    public static char[] insert(char[] dest, int position, char value)
    {
        if (dest == null) return null;

        int count = dest.length;
        dest = realloc(dest, count + 1);

        if ((position < 0) || (position >= count))
            position = count;
        else
            arrays.move(dest, (position+1), dest, position, (count - position));

        dest[position] = value;
        return dest;
    }/*}}}*/
    // public static short[] insert(short[] dest, int position, short value);/*{{{*/
    /**
     * @copydoc insert(byte[],int,byte)
     **/
    public static short[] insert(short[] dest, int position, short value)
    {
        if (dest == null) return null;

        int count = dest.length;
        dest = realloc(dest, count + 1);

        if ((position < 0) || (position >= count))
            position = count;
        else
            arrays.move(dest, (position+1), dest, position, (count - position));

        dest[position] = value;
        return dest;
    }/*}}}*/
    // public static int [] insert(int [] dest, int position, int  value);/*{{{*/
    /**
     * @copydoc insert(byte[],int,byte)
     **/
    public static int [] insert(int [] dest, int position, int  value)
    {
        if (dest == null) return null;

        int count = dest.length;
        dest = realloc(dest, count + 1);

        if ((position < 0) || (position >= count))
            position = count;
        else
            arrays.move(dest, (position+1), dest, position, (count - position));

        dest[position] = value;
        return dest;
    }/*}}}*/
    // public static long[] insert(long[] dest, int position, long value);/*{{{*/
    /**
     * @copydoc insert(byte[],int,byte)
     **/
    public static long[] insert(long[] dest, int position, long value)
    {
        if (dest == null) return null;

        int count = dest.length;
        dest = realloc(dest, count + 1);

        if ((position < 0) || (position >= count))
            position = count;
        else
            arrays.move(dest, (position+1), dest, position, (count - position));

        dest[position] = value;
        return dest;
    }/*}}}*/
    // public static <T> T[] insert(T[] dest, int position, T value);/*{{{*/
    /**
     * Inserts a value into the specified position.
     * Memory for the array will be reallocated to create room for the new
     * value.
     * \param dest Destination array. Cannot be \b null.
     * \param position The position where the value should be inserted. Values
     * in the array, starting from this point, will be shifted so the new
     * value can be acomodated. If this value is less than zero or greater
     * than the length of the array \a dest, the value will be appended to the
     * array.
     * \param value Value to be inserted.
     * \return The new allocated array.
     **/
    public static <T> T[] insert(T[] dest, int position, T value)
    {
        if (dest == null) return null;

        int count = dest.length;
        dest = realloc(dest, count + 1);

        if ((position < 0) || (position >= count))
            position = count;
        else
            arrays.move(dest, (position+1), dest, position, (count - position));

        dest[position] = value;
        return dest;
    }/*}}}*/
    //@}

    /** \name Remotion */ //@{
    // public static byte[] remove(byte[] array, int position);/*{{{*/
    /**
     * Removes an element from the array.
     * \param array Array to remove the element.
     * \param position Position of the element to remove.
     * \return The array with the element removed.
     * \remarks The function will reallocates the array so its length can be
     * strainthen. The result will be this new reallocated array.
     **/
    public static byte[] remove(byte[] array, int position)
    {
        if (array == null) return null;

        int count = array.length - 1;
        if (position < count) {
            arrays.move(array, position, array, (position+1), (count - position));
        }
        return arrays.realloc(array, count);
    }/*}}}*/
    // public static char[] remove(char[] array, int position);/*{{{*/
    /**
     * @copydoc remove(byte[])
     **/
    public static char[] remove(char[] array, int position)
    {
        if (array == null) return null;

        int count = array.length - 1;
        if (position < count) {
            arrays.move(array, position, array, (position+1), (count - position));
        }
        return arrays.realloc(array, count);
    }/*}}}*/
    // public static short[] remove(short[] array, int position);/*{{{*/
    /**
     * @copydoc remove(byte[])
     **/
    public static short[] remove(short[] array, int position)
    {
        if (array == null) return null;

        int count = array.length - 1;
        if (position < count) {
            arrays.move(array, position, array, (position+1), (count - position));
        }
        return arrays.realloc(array, count);
    }/*}}}*/
    // public static int [] remove(int [] array, int position);/*{{{*/
    /**
     * @copydoc remove(byte[])
     **/
    public static int [] remove(int [] array, int position)
    {
        if (array == null) return null;

        int count = array.length - 1;
        if (position < count) {
            arrays.move(array, position, array, (position+1), (count - position));
        }
        return arrays.realloc(array, count);
    }/*}}}*/
    // public static long[] remove(long[] array, int position);/*{{{*/
    /**
     * @copydoc remove(byte[])
     **/
    public static long[] remove(long[] array, int position)
    {
        if (array == null) return null;

        int count = array.length - 1;
        if (position < count) {
            arrays.move(array, position, array, (position+1), (count - position));
        }
        return arrays.realloc(array, count);
    }/*}}}*/
    // public static <T> T[] remove(T[] array, int position);/*{{{*/
    /**
     * Removes an element from the array.
     * \param array Array to remove the element.
     * \param position Position of the element to remove.
     * \return The array with the element removed.
     * \remarks The function will reallocates the array so its length can be
     * strainthen. The result will be this new reallocated array.
     **/
    public static <T> T[] remove(T[] array, int position)
    {
        if (array == null) return null;

        int count = array.length - 1;
        if (position < count) {
            arrays.move(array, position, array, (position+1), (count - position));
        }
        return arrays.realloc(array, count);
    }/*}}}*/
    //@}

    /** \name Appending */ //@{
    // public static byte[] append(byte[] dest, byte[] src);/*{{{*/
    /**
     * Append data from one array to another.
     * \param dest The destination array that will receive the new values.
     * \param src The array where the values should be appended to \a dest.
     * \return The function will reallocate \a dest to make room for the new
     * values. The result is this new allocated array. If \a dest array is \b
     * null or zero length, the result will be \a src. If \a src array is \b
     * null or zero length, the result will be \a dest. When both are \b null,
     * the result will be \b null, of course.
     **/
    public static byte[] append(byte[] dest, byte[] src)
    {
        if (dest == null) return src;
        if (src == null) return dest;

        int size = arrays.length(dest);
        dest = arrays.realloc(dest, size + src.length);
        arrays.copy(dest, 0, src, 0, src.length);
        return dest;
    }/*}}}*/
    // public static char[] append(char[] dest, char[] src);/*{{{*/
    /**
     * @copydoc append(byte[],byte[])
     **/
    public static char[] append(char[] dest, char[] src)
    {
        if (dest == null) return src;
        if (src == null) return dest;

        int size = arrays.length(dest);
        dest = arrays.realloc(dest, size + src.length);
        arrays.copy(dest, 0, src, 0, src.length);
        return dest;
    }/*}}}*/
    // public static short[] append(short[] dest, short[] src);/*{{{*/
    /**
     * @copydoc append(byte[],byte[])
     **/
    public static short[] append(short[] dest, short[] src)
    {
        if (dest == null) return src;
        if (src == null) return dest;

        int size = arrays.length(dest);
        dest = arrays.realloc(dest, size + src.length);
        arrays.copy(dest, 0, src, 0, src.length);
        return dest;
    }/*}}}*/
    // public static int [] append(int [] dest, int [] src);/*{{{*/
    /**
     * @copydoc append(byte[],byte[])
     **/
    public static int [] append(int [] dest, int [] src)
    {
        if (dest == null) return src;
        if (src == null) return dest;

        int size = arrays.length(dest);
        dest = arrays.realloc(dest, size + src.length);
        arrays.copy(dest, 0, src, 0, src.length);
        return dest;
    }/*}}}*/
    // public static long[] append(long[] dest, long[] src);/*{{{*/
    /**
     * @copydoc append(byte[],byte[])
     **/
    public static long[] append(long[] dest, long[] src)
    {
        if (dest == null) return src;
        if (src == null) return dest;

        int size = arrays.length(dest);
        dest = arrays.realloc(dest, size + src.length);
        arrays.copy(dest, 0, src, 0, src.length);
        return dest;
    }/*}}}*/
    // public static <T> T[] append(T[] dest, T[] src);/*{{{*/
    /**
     * Append data from one array to another.
     * \param dest The destination array that will receive the new values.
     * \param src The array where the values should be appended to \a dest.
     * \return The function will reallocate \a dest to make room for the new
     * values. The result is this new allocated array. If \a dest array is \b
     * null or zero length, the result will be \a src. If \a src array is \b
     * null or zero length, the result will be \a dest. When both are \b null,
     * the result will be \b null, of course.
     **/
    public static <T> T[] append(T[] dest, T[] src)
    {
        if (dest == null) return src;
        if (src == null) return dest;

        int size = arrays.length(dest);
        dest = arrays.realloc(dest, size + src.length);
        arrays.copy(dest, 0, src, 0, src.length);
        return dest;
    }/*}}}*/
    //@}

    /** \name Joining Elements of an Array */ //@{
    // public static <T> String join(T[] array, String separator);/*{{{*/
    /**
     * Join elements of an array separated by the given string.
     * \param array The array with objects to join. These objects are
     * converted to String using \c String.valueOf() method.
     * \param separator The separator string to use in the join. If \b null or
     * zero length no separator will be used.
     * \return A string with the elements of the array \a array joined. An
     * empty string will be returned if the array is \b null or zero length.
     **/
    public static <T> String join(T[] array, String separator)
    {
        if (arrays.length(array) == 0) return strings.EMPTY;
        int limit = array.length;
        StringBuilder sb = new StringBuilder(256);

        /* We have two for's() to speed up iteration. */
        if ((separator != null) && (separator.length() > 0))
        {
            sb.append(String.valueOf(array[0]));
            for (int i = 1; i < limit; i++) {
                sb.append(separator).append(String.valueOf(array[i]));
            }
        }
        else
        {
            for (int i = 0; i < limit; i++) {
                sb.append(String.valueOf(array[i]));
            }
        }
        return sb.toString();
    }/*}}}*/
    //@}

    /** \name Slicing Elements from Array */ //@{
    // public static byte[] slice(byte[] array, int first, int count);/*{{{*/
    /**
     * Build an array of a sliced part of anoter array.
     * \param array The original array to be slided. This array will not be
     * changed in this function.
     * \param first Index of the first element to be sliced. If less than zero
     * or greater than the number of elements in the \a array the return will
     * be \b null.
     * \param count Number of elements to be copied from the original \a
     * array. If less than zero or greater than the number of elements in the
     * array only the remaining elements starting from \a first will be
     * copied.
     * \return A new array built from the elements sliced from the original \a
     * array or \b null, if an argument was invalid.
     **/
    public static byte[] slice(byte[] array, int first, int count)
    {
        if ((array == null) || (first < 0) || (first > array.length))
            return null;

        if ((count < 0) || ((first + count) > array.length))
            count = array.length - first;

        byte[] result = new byte[count];
        arrays.copy(result, 0, array, first, count);

        return result;
    }/*}}}*/
    // public static char[] slice(char[] array, int first, int count);/*{{{*/
    /**
     * @copydoc slice(byte[],int,int)
     **/
    public static char[] slice(char[] array, int first, int count)
    {
        if ((array == null) || (first < 0) || (first > array.length))
            return null;

        if ((count < 0) || ((first + count) > array.length))
            count = array.length - first;

        char[] result = new char[count];
        arrays.copy(result, 0, array, first, count);

        return result;
    }/*}}}*/
    // public static short[] slice(short[] array, int first, int count);/*{{{*/
    /**
     * @copydoc slice(byte[],int,int)
     **/
    public static short[] slice(short[] array, int first, int count)
    {
        if ((array == null) || (first < 0) || (first > array.length))
            return null;

        if ((count < 0) || ((first + count) > array.length))
            count = array.length - first;

        short[] result = new short[count];
        arrays.copy(result, 0, array, first, count);

        return result;
    }/*}}}*/
    // public static int [] slice(int [] array, int first, int count);/*{{{*/
    /**
     * @copydoc slice(byte[],int,int)
     **/
    public static int [] slice(int [] array, int first, int count)
    {
        if ((array == null) || (first < 0) || (first > array.length))
            return null;

        if ((count < 0) || ((first + count) > array.length))
            count = array.length - first;

        int[] result = new int[count];
        arrays.copy(result, 0, array, first, count);

        return result;
    }/*}}}*/
    // public static long[] slice(long[] array, int first, int count);/*{{{*/
    /**
     * @copydoc slice(byte[],int,int)
     **/
    public static long[] slice(long[] array, int first, int count)
    {
        if ((array == null) || (first < 0) || (first > array.length))
            return null;

        if ((count < 0) || ((first + count) > array.length))
            count = array.length - first;

        long[] result = new long[count];
        arrays.copy(result, 0, array, first, count);

        return result;
    }/*}}}*/
    // public static <T> T[] slice(T[] array, int first, int count);/*{{{*/
    /**
     * Build an array of a sliced part of anoter array.
     * \param array The original array to be slided. This array will not be
     * changed in this function.
     * \param first Index of the first element to be sliced. If less than zero
     * or greater than the number of elements in the \a array the return will
     * be \b null.
     * \param count Number of elements to be copied from the original \a
     * array. If less than zero or greater than the number of elements in the
     * array only the remaining elements starting from \a first will be
     * copied.
     * \return A new array built from the elements sliced from the original \a
     * array or \b null, if an argument was invalid.
     **/
    public static <T> T[] slice(T[] array, int first, int count)
    {
        if ((array == null) || (first < 0) || (first > array.length))
            return null;

        if ((count < 0) || ((first + count) > array.length))
            count = array.length - first;

        T[] result = (T[])Array.newInstance(array.getClass().getComponentType(), count);
        arrays.copy(result, 0, array, first, count);

        return result;
    }/*}}}*/
    //@}

    /** \name Reading Number from Array */ //@{
    // public static long  readLong (byte[] array, int start);/*{{{*/
    /**
     * Reads a long value from a byte array.
     * \param array The array to be read.
     * \param start Position where the reading should start. The array must
     * have, at least, 8 bytes from this point.
     * \return The long value read or \b 0 if the function fails.
     * \remarks The default byte order in Java is \b Big-Endian.
     **/
    public static long readLong(byte[] array, int start) {
        return (((long)(array[start+0] & 0xFF) << 56) |
                ((long)(array[start+1] & 0xFF) << 48) |
                ((long)(array[start+2] & 0xFF) << 40) |
                ((long)(array[start+3] & 0xFF) << 32) |
                ((long)(array[start+4] & 0xFF) << 24) |
                ((long)(array[start+5] & 0xFF) << 16) |
                ((long)(array[start+6] & 0xFF) <<  8) |
                ((long)(array[start+7] & 0xFF))
               );
    }/*}}}*/
    // public static int   readInt  (byte[] array, int start);/*{{{*/
    /**
     * Reads an int value from a byte array.
     * \param array The array to be read.
     * \param start Position where the reading should start. The array must
     * have, at least, 4 bytes from this point.
     * \return The int value read or \b 0 if the function fails.
     * \remarks The default byte order in Java is \b Big-Endian.
     **/
    public static int  readInt (byte[] array, int start) {
        return (((array[start+0] & 0xFF) << 24) |
                ((array[start+1] & 0xFF) << 16) |
                ((array[start+2] & 0xFF) <<  8) |
                (array[start+3] & 0xFF)
               );
    }/*}}}*/
    // public static short readShort(byte[] array, int start);/*{{{*/
    /**
     * Reads a short value from a byte array.
     * \param array The array to be read.
     * \param start Position where the reading should start. The array must
     * have, at least, 2 bytes from this point.
     * \return The short value read or \b 0 if the function fails.
     * \remarks The default byte order in Java is \b Big-Endian.
     **/
    public static short readShort(byte[] array, int start) {
        return (short)((array[start+0] << 8) | (array[start+1] & 0xFF));
    }/*}}}*/
    // public static long  readLittleEndLong (byte[] array, int start);/*{{{*/
    /**
     * Reads a long value from a byte array.
     * \param array The array to be read.
     * \param start Position where the reading should start. The array must
     * have, at least, 8 bytes from this point.
     * \return The long value read or \b 0 if the function fails.
     * \remarks This function assumes that the order of bytes in the array is
     * \b Little-Endian.
     **/
    public static long  readLittleEndLong (byte[] array, int start) {
        return (((long)(array[start+7] & 0xFF) << 56) |
                ((long)(array[start+6] & 0xFF) << 48) |
                ((long)(array[start+5] & 0xFF) << 40) |
                ((long)(array[start+4] & 0xFF) << 32) |
                ((long)(array[start+3] & 0xFF) << 24) |
                ((long)(array[start+2] & 0xFF) << 16) |
                ((long)(array[start+1] & 0xFF) <<  8) |
                ((long)(array[start+0] & 0xFF))
               );
    }/*}}}*/
    // public static int   readLittleEndInt  (byte[] array, int start);/*{{{*/
    /**
     * Reads an int value from a byte array.
     * \param array The array to be read.
     * \param start Position where the reading should start. The array must
     * have, at least, 4 bytes from this point.
     * \return The int value read or \b 0 if the function fails.
     * \remarks This function assumes that the order of bytes in the array is
     * \b Little-Endian.
     **/
    public static int   readLittleEndInt  (byte[] array, int start) {
        return (((array[start+3] & 0xFF) << 24) |
                ((array[start+2] & 0xFF) << 16) |
                ((array[start+1] & 0xFF) <<  8) |
                (array[start+0] & 0xFF)
               );
    }/*}}}*/
    // public static short readLittleEndShort(byte[] array, int start);/*{{{*/
    /**
     * Reads a short value from a byte array.
     * \param array The array to be read.
     * \param start Position where the reading should start. The array must
     * have, at least, 2 bytes from this point.
     * \return The short value read or \b 0 if the function fails.
     * \remarks This function assumes that the order of bytes in the array is
     * \b Little-Endian.
     **/
    public static short readLittleEndShort(byte[] array, int start) {
        return (short)((array[start+1] << 8) | (array[start] & 0xFF));
    }/*}}}*/
    //@}

    /** \name Writing Number to Array */ //@{
    // public static byte[] writeLong (byte[] array, int start, long value);/*{{{*/
    /**
     * Writes a long value into a byte array.
     * \param array Array where the value will be written. Can be \b null.
     * \param start Position to start write the number. The \a array array
     * must have, at least, 8 bytes available from this position. If \a array
     * is \b null this parameter is ignored.
     * \param value Value to write into the array.
     * \returns The function returns \a array with the value written. If \a
     * array is \b null the function will allocate a new array and write the
     * value on it. Then the new array will be the result.
     * \remarks Java default byte order is \b Big-Endian.
     **/
    public static byte[] writeLong (byte[] array, int start, long value) {
        if (array == null) {
            array = new byte[8];
            start = 0;
        }
        array[start+0] = (byte)(0xFF & (value >> 56));
        array[start+1] = (byte)(0xFF & (value >> 48));
        array[start+2] = (byte)(0xFF & (value >> 40));
        array[start+3] = (byte)(0xFF & (value >> 32));
        array[start+4] = (byte)(0xFF & (value >> 24));
        array[start+5] = (byte)(0xFF & (value >> 16));
        array[start+6] = (byte)(0xFF & (value >>  8));
        array[start+7] = (byte)(0xFF & value);
        return array;
    }/*}}}*/
    // public static byte[] writeInt  (byte[] array, int start, int value);/*{{{*/
    /**
     * Writes an integer value into a byte array.
     * \param array Array where the value will be written. Can be \b null.
     * \param start Position to start write the number. The \a array array
     * must have, at least, 4 bytes available from this position. If \a array
     * is \b null this parameter is ignored.
     * \param value Value to write into the array.
     * \returns The function returns \a array with the value written. If \a
     * array is \b null the function will allocate a new array and write the
     * value on it. Then the new array will be the result.
     * \remarks Java default byte order is \b Big-Endian.
     **/
    public static byte[] writeInt  (byte[] array, int start, int value) {
        if (array == null) {
            array = new byte[4];
            start = 0;
        }
        array[start+0] = (byte)(0xFF & (value >> 24));
        array[start+1] = (byte)(0xFF & (value >> 16));
        array[start+2] = (byte)(0xFF & (value >>  8));
        array[start+3] = (byte)(0xFF & value);
        return array;
    }/*}}}*/
    // public static byte[] writeShort(byte[] array, int start, short value);/*{{{*/
    /**
     * Writes a short value into a byte array.
     * \param array Array where the value will be written. Can be \b null.
     * \param start Position to start write the number. The \a array array
     * must have, at least, 2 bytes available from this position. If \a array
     * is \b null this parameter is ignored.
     * \param value Value to write into the array.
     * \returns The function returns \a array with the value written. If \a
     * array is \b null the function will allocate a new array and write the
     * value on it. Then the new array will be the result.
     * \remarks Java default byte order is \b Big-Endian.
     **/
    public static byte[] writeShort(byte[] array, int start, short value) {
        if (array == null) {
            array = new byte[2];
            start = 0;
        }
        array[start+0] = (byte)(0xFF & (value >>  8));
        array[start+1] = (byte)(0xFF & value);
        return array;
    }/*}}}*/
    // public static byte[] writeLittleEndLong (byte[] array, int start, long value);/*{{{*/
    /**
     * Writes a long value into a byte array.
     * \param array Array where the value will be written. Can be \b null.
     * \param start Position to start write the number. The \a array array
     * must have, at least, 8 bytes available from this position. If \a array
     * is \b null this parameter is ignored.
     * \param value Value to write into the array.
     * \returns The function returns \a array with the value written. If \a
     * array is \b null the function will allocate a new array and write the
     * value on it. Then the new array will be the result.
     * \remarks This operation will write the number using \b Little-Endian
     * byte order.
     **/
    public static byte[] writeLittleEndLong (byte[] array, int start, long value) {
        if (array == null) {
            array = new byte[8];
            start = 0;
        }
        array[start+7] = (byte)(0xFF & (value >> 56));
        array[start+6] = (byte)(0xFF & (value >> 48));
        array[start+5] = (byte)(0xFF & (value >> 40));
        array[start+4] = (byte)(0xFF & (value >> 32));
        array[start+3] = (byte)(0xFF & (value >> 24));
        array[start+2] = (byte)(0xFF & (value >> 16));
        array[start+1] = (byte)(0xFF & (value >>  8));
        array[start+0] = (byte)(0xFF & value);
        return array;
    }/*}}}*/
    // public static byte[] writeLittleEndInt  (byte[] array, int start, int value);/*{{{*/
    /**
     * Writes an integer value into a byte array.
     * \param array Array where the value will be written. Can be \b null.
     * \param start Position to start write the number. The \a array array
     * must have, at least, 4 bytes available from this position. If \a array
     * is \b null this parameter is ignored.
     * \param value Value to write into the array.
     * \returns The function returns \a array with the value written. If \a
     * array is \b null the function will allocate a new array and write the
     * value on it. Then the new array will be the result.
     * \remarks This operation will write the number using \b Little-Endian
     * byte order.
     **/
    public static byte[] writeLittleEndInt  (byte[] array, int start, int value) {
        if (array == null) {
            array = new byte[4];
            start = 0;
        }
        array[start+3] = (byte)(0xFF & (value >> 24));
        array[start+2] = (byte)(0xFF & (value >> 16));
        array[start+1] = (byte)(0xFF & (value >>  8));
        array[start+0] = (byte)(0xFF & value);
        return array;
    }/*}}}*/
    // public static byte[] writeLittleEndShort(byte[] array, int start, short value);/*{{{*/
    /**
     * Writes a short value into a byte array.
     * \param array Array where the value will be written. Can be \b null.
     * \param start Position to start write the number. The \a array array
     * must have, at least, 2 bytes available from this position. If \a array
     * is \b null this parameter is ignored.
     * \param value Value to write into the array.
     * \returns The function returns \a array with the value written. If \a
     * array is \b null the function will allocate a new array and write the
     * value on it. Then the new array will be the result.
     * \remarks This operation will write the number using \b Little-Endian
     * byte order.
     **/
    public static byte[] writeLittleEndShort(byte[] array, int start, short value) {
        if (array == null) {
            array = new byte[2];
            start = 0;
        }
        array[start+1] = (byte)(0xFF & (value >>  8));
        array[start+0] = (byte)(0xFF & value);
        return array;
    }/*}}}*/
    //@}

    /** \name Convertion to String */ //@{
    // public static String toString(byte[] array, String separator, int frequency);/*{{{*/
    /**
     * Convert the array into its string representation.
     * @param array Byte array with values to convert.
     * @param separator A string to separate groups. Can be \b null.
     * @param frequency The frequency to separate groups. See the example.
     * When \a separtor is \b null, \a frequency is ignored.
     * @returns A string representation of the byte array.
     * @remarks The conversion is done byte by byte, building its
     * representation in a string notation. For example:
     * <pre>
     * byte[] array = { 0x01, 0xA0, 0x2F, 0xFF };
     * arrays.toString(array, "-", 2);
     * arrays.toString(array, " ", 4);
     * </pre>
     * Then it will be converted in these strings:
     * <pre>
     * "01-A0-2F-FF"
     * "01A0 2FFF"
     * </pre>
     * Where each byte is represented by two characters.
     **/
    public static String toString(byte[] array, String separator, int frequency)
    {
        int    limit = arrays.length(array);
        int    extra = (separator == null ? 0 : separator.length() * limit);
        StringBuilder sb = new StringBuilder(limit*2 + extra);

        /* Two separated for loops for performance reasons. */
        if (separator != null)
        {
            for (int i = 0; i < limit; i++) {
                if ((i>0) && (((i+1) % frequency) == 0))
                    sb.append(separator);
                sb.append(String.format("%02X", array[i]));
            }
        }
        else
        {
            for (int i = 0; i < limit; i++)
                sb.append(String.format("%02X", array[i]));
        }
        return sb.toString();
    }/*}}}*/
    // public static String toString(byte[] array);/*{{{*/
    /**
     * Converts a byte array into its string representation.
     * This method is a shortcut to arrays::toString(byte[],String,int).
     * \param array Byte array with values to convert.
     * \returns A string representation of the byte array.
     **/
    public static String toString(byte[] array) {
        return arrays.toString(array, null, 0);
    }/*}}}*/
    // public static String toString(char[] array, int start, int count);/*{{{*/
    /**
     * Converts a char array into a String object.
     * @param array The array to convert in String object.
     * @param start The starting index. Must be equal or greater than 0 and
     * less than the length of the array.
     * @param count The number of elements to convert starting from \a start.
     * If less than 0 all elements starting from \a start up to the length of
     * the array will be used.
     * @return The String object result of the conversion or an empty string
     * if some error occured.
     **/
    public static String toString(char[] array, int start, int count)
    {
        if ((start < 0) || (start >= arrays.length(array)))
            return strings.EMPTY;

        if (count < 0) count = (arrays.length(array) - start);

        try { return new String(array, start, count); }
        catch (Exception ex) { /* Ignored. */ }
        return strings.EMPTY;
    }/*}}}*/
    // public static String utf8String(byte[] array, int start);/*{{{*/
    /**
     * Convert the array into a modified UTF-8 Java string.
     * \param array Byte array with data to be parsed.
     * \param start The index of the first byte in the array.
     * \remarks The convertion takes the first two bytes as the number of
     * bytes to read. The following sequence must be a valid UTF-8 java
     * encoded string.
     * \return A string with the value parsed or \b null if an error is
     * encontered.
     **/
    public static String utf8String(byte[] array, int start) {
        int limit = arrays.length(array) - start;
        if (limit <= 2) return null;            /* Impossible conversion. */

        int count = 0x0000FFFF & arrays.readShort(array, start);
        if (count > limit) return null;         /* Invalid length. */

        int i = start, c = 0;
        byte temp;
        char[] data;

        limit = arrays.length(array);

        /* We alloc memory previously to gain performance. */
        data = new char[count];

        while (i < limit)
        {
            /* First bit is 0 or 1: single byte char. */
            if ((array[i] & 0x80) == 0x00)
                data[c] = (char)(array[i] & 0xFF);

            /* First three bits are 110: double byte character. */
            else if ((array[i] & 0xC0) == 0xC0) {
                data[c] = (char)(((array[i] & 0x1F) << 6) | (array[i+1] & 0x3F));
                i++;
            }

            /* First four bits are 1110: three byte character. */
            else if ((array[i] & 0xE0) == 0xE0) {
                data[c] = (char)(((array[i] & 0x0F) << 12) | ((array[i+1] & 0x3F) << 6) | (array[i+2] & 0x3F));
                i+=2;
            }

            /* Otherwise this is a bad encoded string. */
            else
                return null;

            i++;
            c++;
        }

        try { return new String(data, 0, c); }
        catch (Exception ex) { return null; }
    }/*}}}*/
    //@}

    /** \name Convertion from Strings */ //@{
    // public static byte[] fromString(String binary);/*{{{*/
    /**
     * Converts a string representing an array of bytes into an array of
     * bytes.
     * This function supports separators, as of the \c toString()
     * version can return string using separators. Any character is accepted
     * as a separator as long it is not a valid hexadecimal character.
     * \param binary The byte array representation in a string.
     * \return The byte array extracted from the string.
     **/
    public static byte[] fromString(String binary)
    {
        char[] nibbles;
        int i, x, limit = ((binary != null) ? binary.length() : 0);

        if (limit == 0) return new byte[0];

        /* First we remove any non hexadecimal character, forming an array of
         * remaining values.
         */
        String hexDigits = "0123456789ABCDEFabcdef";
        char   c;
        nibbles = new char[limit];
        for (i = 0, x = 0; i < limit; i++) {
            if (hexDigits.indexOf(c = binary.charAt(i)) >= 0)
                nibbles[x++] = (char)Character.digit(c, 16);
        }

        /* Now we converte each two characters into a byte value. */
        int value;
        byte[] result = new byte[x/2];      /* x has the final number of nibbles found. */

        limit = result.length * 2;      /* In the case when x is odd. */
        i = x = 0;
        while (i < limit) {
            value = nibbles[i++] * 16;
            value += nibbles[i++];
            result[x++] = (byte)(value & 0x000000FF);
        }
        return result;
    }/*}}}*/
    //@}

    /** \name Scramble Routines */ //@{
    // public static void randomize(byte[] array);/*{{{*/
    /**
     * Fills an array with random values.
     * \param array The byte array to be filled. The entire array will be
     * filled with random values.
     **/
    public static void randomize(byte[] array) {
        Random random = new Random();
        try { random.nextBytes(array); }
        catch (Exception ex) {
            /* array is NULL. */
        }
    }/*}}}*/
    // public static short crc16(byte[] array);/*{{{*/
    /**
     * Generates a CRC CCITT of 16 bits of a byte array.
     * \param array The bytes to use for the calculation.
     * \return The value of the CRC-CCITT 16 bits.
     **/
    public static short crc16(byte[] array)
    {
        int result = 0x0000FFFF;

        if (array == null) return (short)result;

        int count = array.length;

        for (int i = 0; i < count; i++)
        {
            result  = (((result >> 8) | (result << 8)) & 0x0000FFFF);
            result ^= (array[i] & 0x000000FF);
            result ^= (((result & 0x000000FF) >> 4) & 0x0000FFFF);
            result ^= ((result << 12) & 0x0000FFFF);
            result ^= (((result & 0x000000FF) << 5) & 0x0000FFFF);
        }
        return (short)(result & 0x0000FFFF);
    }/*}}}*/
    //@}
}
// vim:syntax=java.doxygen
