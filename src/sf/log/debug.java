/**
 * \file
 * Defines the \c debug class.
 *
 * \author Alessandro Antonello <aantonello@paralaxe.com.br>
 * \date   Setembro 17, 2014
 * \since  Simple (Java) Framework 2.5
 *
 * \copyright
 * This file is provided in hope that it will be useful to someone. It is
 * offered in public domain. You may use, modify or distribute it freely.
 *
 * The code is provided "AS IS". There is no warranty at all, of any kind. You
 * may change it if you like. Or just use it as it is.
 */
package sf.log;

/* #imports {{{ */
import sf.lang.*;
/* }}} #imports */

/**
 * This class is used for debugging output and logging.
 * The debugging output is redirected to the current standard output. This can
 * be the current terminal or other logging facility. It depends on the value
 * of \c sf.lang.RUNTIME#ANDROID constant. When \c RUNTIME.ANDROID is \b true
 * the output will be redirected to the \c android.util.Log class. Otherwise
 * the \c System.out stream will be used.
 *
 * The static field #enabled can be used to control the output. When \b false
 * no output will be written. All public functions of this class check this
 * value before doing anything so, the only overhead is the function call.
 * @since 2.5
 *//* --------------------------------------------------------------------- */
public final class debug
{
    /** \name Configuration Members */ //@{
    // public static boolean enabled    = true;/*{{{*/
    /**
     * Defines when the debugging output is enabled.
     * When \b true debugging output is enabled. When \b false no output will
     * be written. The default value is \b true.
     * @since 2.5
     **/
    public static boolean enabled = true;
    /*}}}*/
    // public static boolean timestamp  = false;/*{{{*/
    /**
     * Sets whether the timestamp will be written before any output string.
     * The timestamp format can be controlled by #timeformat value. The
     * default value is \b false. That is, no timestamp will be written.
     * @since 2.5
     **/
    public static boolean timestamp = false;
    /*}}}*/
    // public static String  timeformat = "%d/%m/%Y %H:%M:%S.%s";/*{{{*/
    /**
     * Controls the format of the timestamp of the output.
     * The default format has the complete date and time, including
     * milliseconds. The application can change this accordingly. Notice that
     * this value has no effect when #timestamp is \b false.
     * @since 2.5
     **/
    public static String  timeformat = "%d/%m/%Y %H:%M:%S.%s";
    /*}}}*/
    // public static String  tag        = "XXX";/*{{{*/
    /**
     * Output tagging.
     * This has meaning when used in Android where the output can be filtered
     * by tagging prefix. This value is passed to all calls to \c
     * android.util.Log class. It can be changed by the application freely. It
     * is not touched by the classes of this library.
     * @since 2.5
     **/
    public static String  tag        = "XXX";
    /*}}}*/
    //@}

    /** \name Internal Methods */ //@{
    // static void write(String output);/*{{{*/
    /**
     * Does the output of the logging.
     * @param output The string to write.
     * @since 2.5
     **/
    static void write(String output)
    {
        if (RUNTIME.ANDROID)
            android.util.Log.v(debug.tag, output);
        else
            System.out.write(output);
    }/*}}}*/
    //@}
}
// vim:syntax=java.doxygen
