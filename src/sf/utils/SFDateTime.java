/**
 * \file
 * Defines the class SFDateTime.
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
package sf.utils;

/* #imports {{{ */
import java.util.TimeZone;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;

import sf.lang.ENC;
import sf.lang.ERROR;
/* }}} #imports */

/**
 * A date and time helper class.
 * The class is very light. The information holded takes only 64 bits of
 * memory. Each value is kept separated in data members but some values are
 * recorded in nibbles or hiwords of members. Recording in this way brings
 * some advantages when a single value like #day() or #year() is required. The
 * result is a single member lookup. But also has some disadvantages becouse
 * the #set(long) and #get() operations are very expensive.
 * @since 2.5
 *//* --------------------------------------------------------------------- */
public class SFDateTime
{
    /** \name Data Members */ //@{
    // private short m_msecs;/*{{{*/
    /**
     * Milliseconds in the current second.
     * This value is always positive. Negative millisencods are not allowed.
     * The high order byte of this member also holds the day of week.
     * @since 2.5
     **/
    private short m_msecs;
    /*}}}*/
    // private short m_year;/*{{{*/
    /**
     * The year number.
     * Hold values between \c Short.MIN_VALUE and \c Short.MAX_VALUE but not
     * zero. There is no year zero. Zero for this value is an invalid year
     * number.
     * @since 2.5
     **/
    private short m_year;
    /*}}}*/
    private byte  m_month;      /**< Month number between 1 and 12.         */
    private byte  m_day;        /**< Day of month between 1 and 31.         */
    private byte  m_hour;       /**< Hour of day between 0 and 23.          */
    private byte  m_min;        /**< Minute in the hour between 0 and 59.   */
    private byte  m_sec;        /**< Seconds in the minute between 0 and 59.*/
    //@}
}
// vim:syntax=java.doxygen
