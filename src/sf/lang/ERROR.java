/**
 * \file
 * Defines the ERROR class for constants definitions.
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
 * Declares all error constants used in this library.
 * This library doesn't throw exceptions. Instead, all possible failures are
 * returned in the form of error codes. Error codes are always less than zero
 * to differentiate them from others results.
 *
 * If the application needs to define its own set of error codes pay attention
 * to the limit value of ERROR#USER. Any error code defined out size this
 * library must be less than this value.
 *//* --------------------------------------------------------------------- */
public final class ERROR
{
    public static final int SUCCESS = 0;    /**< Means success or no error. */
    public static final int FAILED  = -1;   /**< Failure. Usually a exception. */
    public static final int ACCESS  = -2;   /**< Access denied.             */
    public static final int NODATA  = -3;   /**< Invalid data.              */
    public static final int CRC     = -4;   /**< Bad CRC.                   */
    public static final int LENGTH  = -5;   /**< Invalid array length.      */
    public static final int WRITE   = -6;   /**< I/O write failure.         */
    public static final int READ    = -7;   /**< I/O read failure.          */
    public static final int IO      = -8;   /**< General I/O failure.       */
    public static final int INDEX   = -9;   /**< Invalid array index.       */
    public static final int PARM    = -10;  /**< Invalid argument.          */
    public static final int ABORTED = -11;  /**< Operation aborted.         */
    public static final int NOTFOUND = -12; /**< Item not found.            */
    public static final int FULL    = -13;  /**< Not enough storage space.  */
    public static final int EOF     = -14;  /**< End of file found.         */
    public static final int NOMEM   = -15;  /**< Not enough memory.         */
    public static final int EXISTS  = -16;  /**< Item already exists.       */
    public static final int POINTER = -17;  /**< Invalid pointer address.   */
    public static final int EXPIRED = -18;  /**< Timeout interval expired.  */
    public static final int ACTIVE  = -19;  /**< Operation still active.    */
    public static final int CHARSET = -20;  /**< Invalid character set.     */
    public static final int EXCEPTION = -21;    /**< Unknown exception.     */
    public static final int PORT    = -22;  /**< Invalid port number.       */
    public static final int ADDR    = -23;  /**< Invalid address or URL.    */
    public static final int SPACE   = -24;  /**< Insufficient buffer space. */
    public static final int NORSRC  = -25;  /**< Resource not found.        */
    public static final int RCFILE  = -26;  /**< Invalid resource file.     */
    public static final int NOCONN  = -27;  /**< Not connected.             */
    public static final int UNREACH = -28;  /**< Unreachable network.       */
    public static final int RUNNING = -29;  /**< Thread already running.    */
    public static final int CLOSED  = -30;  /**< Operation is closed.       */
    public static final int SERVER  = -31;  /**< An internal server error.  */
    public static final int FORMAT  = -32;  /**< Invalid format.            */
    public static final int REFUSED = -33;  /**< Connection refused.        */
    public static final int VERSION = -34;  /**< Wrong version number.      */
    public static final int UNRESOLVED = -35; /**< Unresolved address.      */
    public static final int HOST    = -36;  /**< Host is unreachable.       */
    public static final int USER    = -1000;    /**< Start of user space.   */
}
// vim:syntax=java.doxygen
