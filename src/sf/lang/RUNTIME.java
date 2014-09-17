/**
 * \file
 * Defines the RUNTIME interface.
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
package sf.lang;

/**
 * \ingroup sf_lang
 * Interface with runtime constants.
 * This class lists some runtime constants used on internal class or function
 * implementations. It set path for execution patterns and which API will be
 * choosed (between standard JVM or Android).
 *//* --------------------------------------------------------------------- */
public interface RUNTIME
{
    // public static final boolean ANDROID = true;/*{{{*/
    /**
     * Sets the destination of some operations to Android runtime.
     * @remarks When \b true tools like \c debug or \c assets will be directed
     * to use operations specific for Android. When \b false that tools will
     * use operations of the standard Java runtime.
     * @note This constant value should be changed before compilation. The
     * default value is \b true.
     * @since 2.5
     **/
    public static final boolean ANDROID = true;
    /*}}}*/
    // public static final boolean DEBUG   = true;/*{{{*/
    /**
     * Used for the debugging of this library.
     * This constant don't change the usage of the \c debug class. It's only
     * purpose is to show or hide debugging output of internal methods of
     * this library. It's default value is \b false. It is turned \b true when
     * some new features are added and needed to be tested.
     * @since 2.5
     **/
    public static final boolean DEBUG   = true;
    /*}}}*/
}
// vim:syntax=java.doxygen
