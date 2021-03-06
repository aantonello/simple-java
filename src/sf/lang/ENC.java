/**
 * \file
 * Defines the ENC class for constants definitions.
 *
 * \author Alessandro Antonello <aantonello@paralaxe.com.br>
 * \date   Agosto 26, 2013
 * \since  Simple Framework 2.5
 *
 * \par License
 * Apache v2 License.
 */
package sf.lang;

/**
 * \ingroup sf_lang
 * Recognized string encoding constants.
 * This set of constants are used in several classes to encode or decode
 * from different character encodings. Specially the classes \c strings and
 * \c arrays use these constants heavily.
 *//* --------------------------------------------------------------------- */
public interface ENC
{
    public static final String ASCII   = "US-ASCII";    /**< ASCII encoding.*/
    public static final String LATIN1  = "ISO-8859-1";  /**< Latin1 encoding.*/
    public static final String UTF16   = "UTF-16";      /**< UTF16 with BOM. */
    public static final String UTF8    = "UTF-8";       /**< UTF-8 encoding.*/
    public static final String UTF16LE = "UTF-16le";    /**< UTF-16 little endian encoding. */
    public static final String UTF16BE = "UTF-16be";    /**< UTF-16 big endian encoding. */
    public static final String UTF32LE = "UTF-32le";    /**< UTF-32 little endian encoding. */
    public static final String UTF32BE = "UTF-32be";    /**< UTF-32 big endian encoding. */
}
// vim:syntax=java.doxygen
