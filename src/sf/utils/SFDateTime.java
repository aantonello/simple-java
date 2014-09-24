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
import java.util.Locale;
import java.util.Date;
import java.text.DateFormat;

import sf.lang.*;
/* }}} #imports */

/**
 * A date and time helper class.
 * The class is very light. The information holded takes only 12 bytes of
 * memory. Each value is kept separated in data members but some values are
 * recorded in nibbles or hiwords of members. Recording in this way brings
 * some advantages when a single value like #day() or #year() is required. The
 * result is a single member lookup. But also has some disadvantages becouse
 * the #set(long) and #get() operations are very expensive.
 * @since 2.5
 *//* --------------------------------------------------------------------- */
public class SFDateTime
{
    /** \name Constructors */ //@{
    // public SFDateTime();/*{{{*/
    /**
     * Default constructor.
     * Constructs an invalid object.
     * @since 2.5
     **/
    public SFDateTime()
    {
        m_time = null;
    }/*}}}*/
    // public SFDateTime(long milliseconds);/*{{{*/
    /**
     * Constructs the object based on the passed value.
     * @param milliseconds Milliseconds between the current time and <i>the
     * epoch</i>. Usually this value can be \c System.currentTimeMillis().
     * @since 2.5
     **/
    public SFDateTime(long milliseconds)
    {
        set( milliseconds );
    }/*}}}*/
    // public SFDateTime(long milliseconds, TimeZone tz);/*{{{*/
    /**
     * Constructs the object setting its time and time zone.
     * @param milliseconds Milliseconds passed UTC.
     * @param tz The time zone to convert the UTC time. To the value
     * passed through \a milliseconds the offset defined in the \a tz
     * TimeZone object will be applied. So, \a milliseconds must be in UTC
     * time.
     * @since 2.5
     **/
    public SFDateTime(long milliseconds, TimeZone tz)
    {
        set(milliseconds, tz);
    }/*}}}*/
    //@}

    /** \name Static Helper Functions */ //@{
    // public static SFDateTime now();/*{{{*/
    /**
     * Builds a \c SFDateTime object with the current date and time.
     * @return The created object.
     * @remarks The date and time returned are UTC based, not local date and
     * time.
     * @since 2.5
     **/
    public static SFDateTime now()
    {
        return new SFDateTime(System.currentTimeMillis());
    }/*}}}*/
    // public static SFDateTime now(TimeZone tz);/*{{{*/
    /**
     * Builds a \c SFDateTime object with the current date and time.
     * @param tz \c TimeZone to localize the time.
     * @return The created object.
     * @remarks The date and time returned are localized according to the
     * passed \a tz object.
     * @since 2.5
     **/
    public static SFDateTime now(TimeZone tz)
    {
        return new SFDateTime(System.currentTimeMillis(), tz);
    }/*}}}*/
    // public static boolean isLeapYear(int year);/*{{{*/
    /**
     * Checks if a year is leap year.
     * @param year The year number.
     * @returns \b true if the year is leap year. \b false otherwise.
     * @note Zero (0) is an invalid year.
     * @since 2.5
     **/
    public static boolean isLeapYear(int year)
    {
        return time_t.leapYear(year);
    }/*}}}*/
    //@}

    /** \name Attributes */ //@{
    // public final boolean isValid();/*{{{*/
    /**
     * Checks whether this object has valid data/time information.
     * @returns \b true if the information is valid. \b false otherwise.
     * @since 2.5
     **/
    public final boolean isValid()
    {
        return (m_time != null);
    }/*}}}*/
    //@}

    /** \name Date/Time Attributes */ //@{
    // public int year();/*{{{*/
    /**
     * Gets the year number.
     * @return If this object has a valid date/time value the result will be
     * the year number. Otherwise the function returns \b -1.
     * @since 2.5
     **/
    public int year()
    {
        return ((m_time != null) ? m_time.year : -1);
    }/*}}}*/
    // public int month();/*{{{*/
    /**
     * Gets the month number.
     * 1 is January, 12 is December.
     * @return If this object has a valid date/time value the result will be
     * the month number. Otherwise the function returns \b -1.
     * @since 2.5
     **/
    public int month()
    {
        return ((m_time != null) ? numbers.int8_to32(m_time.month) : -1);
    }/*}}}*/
    // public int day();/*{{{*/
    /**
     * Get the day of the month.
     * Always start at 1, which is the first day of the month. Can go until
     * 31, depending on the current month.
     * @return If this object has a valid date/time value the result will be
     * the day number. Otherwise the function returns \b -1.
     * @since 2.5
     **/
    public int day()
    {
        return ((m_time != null) ? numbers.int8_to32(m_time.day) : -1);
    }/*}}}*/
    // public int hour();/*{{{*/
    /**
     * Gets the current hour.
     * Starts at 0 (mid night) and end up at 23.
     * @return If this object has a valid date/time value the result will be
     * the hour number. Otherwise the function returns \b -1.
     * @since 2.5
     **/
    public int hour()
    {
        return ((m_time != null) ? numbers.int8_to32(m_time.hour) : -1);
    }/*}}}*/
    // public int minute();/*{{{*/
    /**
     * Get the minute in the current hour.
     * Starts at 0 and end up at 59.
     * @return If this object has a valid date/time value the result will be
     * the minute number. Otherwise the function returns \b -1.
     * @since 2.5
     **/
    public int minute()
    {
        return ((m_time != null) ? numbers.int8_to32(m_time.min) : -1);
    }/*}}}*/
    // public int seconds();/*{{{*/
    /**
     * Gets the seconds in the current minute.
     * Starts at 0 and end up at 59.
     * @return If this object has a valid date/time value the result will be
     * the seconds value. Otherwise the function returns \b -1.
     * @since 2.5
     **/
    public int seconds()
    {
        return ((m_time != null) ? numbers.int8_to32(m_time.secs) : -1);
    }/*}}}*/
    // public int milliSeconds();/*{{{*/
    /**
     * Gets the milliseconds within the current second.
     * Starts at 0 and end up at 999.
     * @return If this object has a valid date/time value the result will be
     * the milliseconds value. Otherwise the function returns \b -1.
     * @since 2.5
     **/
    public int milliSeconds()
    {
        return ((m_time != null) ? numbers.int16_to32(m_time.msecs) : -1);
    }/*}}}*/
    // public int weekDay();/*{{{*/
    /**
     * Retrieves a number representing the day of the week.
     * 1 is Sunday, 7 is Saturday.
     * @return If this object has a valid date/time value the result will be
     * the week day number. Otherwise the function returns \b -1.
     * @since 2.5
     **/
    public int weekDay()
    {
        return ((m_time != null) ? numbers.int8_to32(m_time.wday) : -1);
    }/*}}}*/
    // public int yearDay();/*{{{*/
    /**
     * Gets the number of the day in the year.
     * Values starting at 1 (January 1st.) and end up in 365 or 366.
     * @returns The year day or -1 if the current month is invalid.
     * @since 2.5
     **/
    public int yearDay()
    {
        return ((m_time == null) ? -1 : time_t.dayOfYear(m_time.day, m_time.month, m_time.year));
    }/*}}}*/
    //@}

    /** \name Date/Time Operations */ //@{
    // public final void reset();/*{{{*/
    /**
     * Resets this object.
     * Reseting this object invalidates its date and time information.
     * @since 2.5
     **/
    public final void reset()
    {
        m_time = null;
    }/*}}}*/
    // public final void set(long milliseconds);/*{{{*/
    /**
     * Change the current date/time information.
     * @param milliseconds Milliseconds count since *the epoch* (January 1,
     * 1970 00:00:00), in UTC.
     * @note No convertion will be done in the value passed through \a
     * milliseconds. The date/time information will be used as is.
     * @since 2.5
     **/
    public final void set(long milliseconds)
    {
        m_time = new time_t(milliseconds);
    }/*}}}*/
    // public final void set(long milliseconds, TimeZone tz);/*{{{*/
    /**
     * Change the current date/time information.
     * @param milliseconds The time in UTC milliseconds.
     * @param tz The time zone to convert the UTC time. To the value
     * passed through \a milliseconds the offset defined in the \a tz
     * TimeZone object will be applied. So, \a milliseconds must be in UTC
     * time.
     * @since 2.5
     **/
    public final void set(long milliseconds, TimeZone tz)
    {
        m_time = new time_t(milliseconds, tz);
    }/*}}}*/
    // public final void set(int year, int month, int day, int hour, int minutes, int seconds);/*{{{*/
    /**
     * Sets the date and time according with the passed values.
     * @param year Value for the year. Must be greater or equal to 1970.
     * @param month Month number. Valid ranges are between 1 and 12.
     * @param day Day value. Must be between 1 and 31.
     * @param hour Hour in the day. Between 0 and 23.
     * @param minutes Minutes in the hour. Between 0 and 59.
     * @param seconds Seconds in the minute. Between 0 and 59.
     * @remarks The function does not have return value and will not throw any
     * exception if one of its arguments are invalid. Instead, the #isValid()
     * method will return \b true.
     * @since 2.5
     **/
    public final void set(int year, int month, int day, int hour, int minutes, int seconds)
    {
        m_time = null;

        if ((year < time_t.epoch_year) || (month < 1) || (month > 12) || (day < 1) ||
            (hour < 0) || (hour > 23) || (minutes < 0) || (minutes > 59) ||
            (seconds < 0) || (seconds > 59))
            return;

        if (day > time_t.daysInMonth(month, isLeapYear(year)))
            return;

        time_t temp = new time_t();
        temp.year  = year;
        temp.month = (byte)month;
        temp.day   = (byte)day;
        temp.hour  = (byte)hour;
        temp.min   = (byte)minutes;
        temp.secs  = (byte)seconds;

        m_time = new time_t( temp.get() );
    }/*}}}*/
    // public final void date(int year, int month, int day);/*{{{*/
    /**
     * Sets the date and time of this object.
     * @param year Value for the year. Must be greater or equal to 1970.
     * @param month Month number. Valid ranges are between 1 and 12.
     * @param day Day value. Must be between 1 and 31.
     * @remarks Hour, minutes and seconds will be set to 0.
     * @remarks The function does not have return value and will not throw any
     * exception if one of its arguments are invalid. Instead, the #isValid()
     * method will return \b true.
     * @since 2.5
     **/
    public final void date(int year, int month, int day)
    {
        set(year, month, day, 0, 0, 0);
    }/*}}}*/
    // public final void time(int hour, int minutes, int seconds);/*{{{*/
    /**
     * Changes the time part of this object.
     * @param hour Hour in the day. Between 0 and 23.
     * @param minutes Minutes in the hour. Between 0 and 59.
     * @param seconds Seconds in the minute. Between 0 and 59.
     * @remarks This object must already be valid. Otherwise the function will
     * fail and the #isValid() method will return \b false.
     * @since 2.5
     **/
    public final void time(int hour, int minutes, int seconds)
    {
        if (m_time == null) return;
        set(m_time.year, m_time.month, m_time.day, hour, minutes, seconds);
    }/*}}}*/
    // public final long get();/*{{{*/
    /**
     * Returns a \b long value representing the number of milliseconds passed since
     * the epoch (January 1, 1970) according to the value of this object.
     * If this object was created with time zone information the result value
     * will be according to that time zone. If this object is invalid, \b 0
     * will be returned.
     * @since 2.5
     **/
    public final long get()
    {
        return ((m_time == null) ? 0L : m_time.get());
    }/*}}}*/
    //@}

    /** \name Object Overrides */ //@{
    // public boolean equals(Object obj);/*{{{*/
    /**
     * Checks whether this instance is equal another object.
     * @param obj Object to compare to this one.
     * @return \b true if both objects are equals. \b false otherwise. Also,
     * the operation will return \b false if one or both objects are invalid.
     * @remarks The object will be equal only if they point to the same date
     * and same time. Milliseconds are not considered for this comparison.
     * @since 2.5
     **/
    public boolean equals(Object obj)
    {
        if (!(obj instanceof SFDateTime))
            return false;

        SFDateTime dateTime = (SFDateTime)obj;
        if (!isValid() || !dateTime.isValid())
            return false;

        return ((year() == dateTime.year()) && (month() == dateTime.month())
                && (day() == dateTime.day()) && (hour() == dateTime.hour())
                && (minute() == dateTime.minute()) && (seconds() == dateTime.seconds()));
    }/*}}}*/
    // public String  toString();/*{{{*/
    /**
     * Convert this object to a switable string representation.
     * @return A string with the date and time information. If this object is
     * invalid, an empty string will be returned.
     * @remarks This method returns the local representation of date and time,
     * according with the system default locale.
     * @since 2.5
     **/
    public String  toString()
    {
        if (m_time == null) return "";
        return __internal_formatDateTime(Locale.getDefault());
    }/*}}}*/
    //@}

    /** \name Overloads */ //@{
    // public String toString(String fmt);/*{{{*/
    /**
     * Formats the date and time in this object.
     * @param fmt String with format specification. This string accepts a
     * subset of the specifications provided by the \c strftime() standard C
     * function.
     * @remarks The formating specifier is a sequence of a percent sign and a
     * single character (e.g.: '%c'). The folloing fields are recognized:
     * - \b B: The month name.
     * - \b c: Formats the current date and time according to the default
     *         locale specification. The same result as #toString().
     * - \b d: The month day with 2 digits.
     * - \b H: The hour value with 2 digits.
     * - \b m: The month number with 2 digits.
     * - \b M: The minute in the hour with 2 digits.
     * - \b S: The second in the minute with 2 digits.
     * - \b w: The week day number with 1 digit (from 1 to 7).
     * - \b W: The week day name.
     * - \b x: The date according to the locale specification.
     * - \b X: The time according to the locale specification.
     * - \b y: The year number with 2 digits. Avoid using this.
     * - \b Y: The yera number with 4 digits.
     * .
     * @since 2.5
     **/
    public String toString(String fmt)
    {
        return toString(Locale.getDefault(), fmt);
    }/*}}}*/
    // public String toString(Locale l, String fmt);/*{{{*/
    /**
     * Formats the date and time in this object.
     * @param l The Locale object to localize names of days and/or months.
     * @param fmt String with format specification. This string accepts a
     * subset of the specifications provided by the \c strftime() standard C
     * function.
     * @remarks The formating specifier is a sequence of a percent sign and a
     * single character (e.g.: '%c'). The folloing fields are recognized:
     * - \b A: The week day full name.
     * - \b a: The abreviated week day name.
     * - \b B: The full month name.
     * - \b b: The abreviated month name. Usually 3 letters.
     * - \b c: Formats the current date and time according to the locale
     *         specified.
     * - \b d: The month day with 2 digits.
     * - \b H: The hour value with 2 digits.
     * - \b I: The hour value using 12 hour clock (01 to 12).
     * - \b j: The day of the year (001 to 366).
     * - \b m: The month number with 2 digits.
     * - \b M: The minute in the hour with 2 digits.
     * - \b S: The second in the minute with 2 digits.
     * - \b w: The week day number with 1 digit (from 1 to 7, 1 is Sunday).
     * - \b x: The date according to the locale specification.
     * - \b X: The time according to the locale specification.
     * - \b y: The year number with 2 digits. Avoid using this.
     * - \b Y: The yera number with 4 digits.
     * .
     * @since 2.5
     **/
    public String toString(Locale l, String fmt)
    {
        if ((m_time == null) || (fmt == null) || (l == null))
            return strings.EMPTY;

        StringBuffer sb = new StringBuffer(fmt.length());
        char[] chars = fmt.toCharArray();
        int i = 0, limit = chars.length;

        while (i < limit)
        {
            if ((chars[i] != '%') || (i == (limit - 1))) {
                sb.append(chars[i++]);
                continue;
            }
            
            switch (chars[++i]) {
            case 'B':
                sb.append(__internal_monthName(true, m_time.month, l));
                break;
            case 'b':
                sb.append(__internal_monthName(false, m_time.month, l));
                break;
            case 'c':
                sb.append(__internal_formatDateTime(l));
                break;
            case 'd':
                sb.append(String.format("%02d", m_time.day));
                break;
            case 'H':
                sb.append(String.format("%02d", m_time.hour));
                break;
            case 'I':
                if (m_time.hour > 12)
                    sb.append(String.format("%02d", ((m_time.hour / 2) + (m_time.hour % 2))));
                else
                    sb.append(String.format("%02d", m_time.hour));
                break;
            case 'j':
                sb.append(String.format("%03d", this.yearDay()));
                break;
            case 'm':
                sb.append(String.format("%02d", m_time.month));
                break;
            case 'M':
                sb.append(String.format("%02d", m_time.min));
                break;
            case 'S':
                sb.append(String.format("%02d", m_time.secs));
                break;
            case 'w':
                sb.append(String.format("%d", m_time.wday));
                break;
            case 'A':
                sb.append(__internal_weekDay(true, m_time.wday, l));
                break;
            case 'a':
                sb.append(__internal_weekDay(false, m_time.wday, l));
                break;
            case 'x':
                sb.append(__internal_formatDate(l));
                break;
            case 'X':
                sb.append(__internal_formatTime(l));
                break;
            case 'y':
                sb.append(String.format("%02d", m_time.year % 100));
                break;
            case 'Y':
                sb.append(String.format("%04d", m_time.year));
                break;
            default:
                sb.append(chars[i]);
            }
            i++;
        }
        return sb.toString();
    }/*}}}*/
    //@}

    /** @internal */ //@{
    // private static class time_t;/*{{{*/
    /**
     * Implementation and conversion of date/time values.
     * @since 2.5
     **/
    private static class time_t
    {
        /** \name Field Members */ //@{
        public int   year;          /**< The year number.                   */
        public short tz;            /**< Time zone offset, im minutes.      */
        public short dst;           /**< Daylight saving time, in minutes.  */
        public short msecs;         /**< Milliseconds within a second.      */
        public byte  month;         /**< Month number, January is 1.        */
        public byte  day;           /**< Day of month.                      */
        public byte  hour;          /**< 24 hour clock.                     */
        public byte  min;           /**< Minutes in an hour.                */
        public byte  secs;          /**< Seconds in a minute.               */
        public byte  wday;          /**< Week day, 1 is Sunday.             */
        //@}

        /** \name Constructors */ //@{
        // public time_t(long milliseconds, TimeZone tz);/*{{{*/
        /**
         * Constructs the object setting its time and time zone.
         * @param milliseconds Milliseconds passed UTC.
         * @param tz The time zone to convert the UTC time. To the value
         * passed through \a milliseconds the offset defined in the \a tz
         * TimeZone object will be applied. So, \a milliseconds must be in UTC
         * time.
         * @since 2.5
         **/
        public time_t(long milliseconds, TimeZone tz)
        {
            set(milliseconds, tz);
        }/*}}}*/
        // public time_t(long milliseconds);/*{{{*/
        /**
         * Constructs the object setting its time.
         * @param milliseconds The time in milliseconds. Notice that in this
         * constructor no convertion will be done. The date/time information
         * in this argument will be used as is. The #tz and #dst members will
         * be set to 0.
         * @since 2.5
         **/
        public time_t(long milliseconds)
        {
            set(milliseconds);
        }/*}}}*/
        // public time_t();/*{{{*/
        /**
         * Default constructor.
         * Builds an empty object.
         * @since 2.5
         **/
        public time_t()
        {
            this.year = 0;
            this.tz   = this.dst = this.msecs = (short)0;
            this.month = this.day = this.hour = this.min = this.secs = this.wday = (byte)0;
        }/*}}}*/
        //@}

        /** \name Operations */ //@{
        // public final void set(long milliseconds, TimeZone tz);/*{{{*/
        /**
         * Changes the date and time information of this object.
         * @param milliseconds The time in UTC milliseconds.
         * @param tz The time zone to convert the UTC time. To the value
         * passed through \a milliseconds the offset defined in the \a tz
         * TimeZone object will be applied. So, \a milliseconds must be in UTC
         * time.
         * @remarks The #dst and #tz members will be defined according to the
         * \a tz parameter.
         * @since 2.5
         **/
        public final void set(long milliseconds, TimeZone tz)
        {
            int tzOffset  = tz.getRawOffset();
            int dstOffset = tz.getDSTSavings();

            this.set((milliseconds + tzOffset + dstOffset));
            this.tz  = (short)(tzOffset % 3600000);
            this.dst = (short)(dstOffset % 3600000);
        }/*}}}*/
        // public final void set(long milliseconds);/*{{{*/
        /**
         * Changes the date and time information of this object.
         * @param milliseconds The time in milliseconds. Notice that in this
         * operation no convertion will be done. The date/time information
         * in this argument will be used as is. The #tz and #dst members will
         * be set to 0.
         * @since 2.5
         **/
        public final void set(long milliseconds)
        {
            this.tz = this.dst = (short)0;
            long clock, dayno, _msecs;
            int _year = epoch_year;

            clock = (milliseconds % msecs_per_day);
            dayno = (milliseconds / msecs_per_day);

            this.msecs = (short)(clock % 1000);
            this.secs  = (byte)((clock % 60) / 1000);
            this.min   = (byte)((clock % (3600 * 1000)) / 60);
            this.hour  = (byte)(clock / (3600 * 1000));
            this.wday  = (byte)(((dayno + 4) % 7) + 1);

            /* Counting years. */
            while (dayno >= daysInYear(_year)) {
                dayno -= daysInYear(_year);
                _year++;
            }

            this.year  = _year;
            this.month = 1;
            boolean leapY = leapYear(_year);

            /* Counting months */
            while (dayno >= daysInMonth(this.month, leapY)) {
                dayno -= daysInMonth(this.month, leapY);
                this.month++;
            }

            this.day = (byte)(dayno + 1);
        }/*}}}*/
        // public final long get();/*{{{*/
        /**
         * Gets the milliseconds since the epoch (January, 1, 1970).
         * @returns A long value representing the milliseconds since the
         * epoch.
         * @note No conversion is done in the resulting value. If this object
         * was created with a local time, the value returned will be according
         * to this.
         * @since 2.5
         **/
        public final long get()
        {
            int yearsSinceEpoch = this.year - epoch_year;

            long days = (yearsSinceEpoch * 365);
            long seconds = 0;

            /* Adding and removing days according to leap years. */
            days += (yearsSinceEpoch / 4);
            if ((this.year % 4) < (epoch_year % 4))
                days += (yearsSinceEpoch % 4);

            days -= (yearsSinceEpoch / 100);
            if ((this.year % 100) < (epoch_year % 100))
                days += (yearsSinceEpoch % 100);

            days += (yearsSinceEpoch / 400);
            if ((this.year % 400) < (epoch_year % 400))
                days += (yearsSinceEpoch % 400);

            /* Add the days in this year. */
            days += dayOfYear(this.day, this.month, this.year);

            /* Convert to seconds and add hours, minutes and seconds. */
            seconds = (((this.hour * 60) + this.min) * 60) + this.secs;
            seconds += (days * seconds_per_day);

            /* Convert to milliseconds. */
            seconds = (seconds * 1000) + this.msecs;

            return seconds;
        }/*}}}*/
        //@}

        /** \name Static Functions */ //@{
        // public static boolean leapYear(int year);/*{{{*/
        /**
         * Checks whether the passed year is a leap year.
         * @param year The year to check.
         * @returns \b true when \a year is leap year. Otherwise \b false.
         * @since 2.5
         **/
        public static boolean leapYear(int year)
        {
            return (((year % 4) == 0) && (((year % 100) != 0) || ((year % 400) == 0)));
        }/*}}}*/
        // public static int daysInYear(int year);/*{{{*/
        /**
         * Calculates the number of days in an year.
         * @param year The year to check.
         * @return 365 or 366, depending on the year.
         * @since 2.5
         **/
        public static int daysInYear(int year)
        {
            return (leapYear(year) ? 366 : 365);
        }/*}}}*/
        // public static int daysInMonth(int month, boolean leapYear);/*{{{*/
        /**
         * Retrieves the number of days in a month.
         * @param month The month number. 1 is January.
         * @param leapYear Boolean value defining if the month occurs in a
         * leap year.
         * @return The number of days in the passed month.
         * @since 2.5
         **/
        public static int daysInMonth(int month, boolean leapYear)
        {
            if (month == 2) return (leapYear ? 29 : 28);
            if (month < 8)
                return (((month & 0x01) != 0) ? 31 : 30);
            else
                return (((month & 0x01) != 0) ? 30 : 31);
        }/*}}}*/
        // public static int dayOfYear(int day, int month, int year);/*{{{*/
        /**
         * Calculates the number of days passed in a given year.
         * @param day The current day.
         * @param month The month.
         * @param year The Year.
         * @return An integer between 1 and 366. If any parameter is out of
         * range the result will be \b -1.
         * @since 2.5
         **/
        public static int dayOfYear(int day, int month, int year)
        {
            if (year < epoch_year) return -1;

            boolean leapY = leapYear(year);

            if ((month <= 0) || (month > 12)) return -1;
            if ((day < 1) || (day > daysInMonth(month, leapY)))
                return -1;

            int[] days = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
            return days[month] + day + ((month > 2 && leapY) ? 1 : 0);
        }/*}}}*/
        //@}

        /** \name Public Constants */ //@{
        public static final long seconds_per_day = (24 * 60 * 60);      /**< Seconds per day. */
        public static final long msecs_per_day = (seconds_per_day * 1000); /**< Milliseconds in a day. */
        public static final int  epoch_year    = 1970;  /**< The epoch: January, 1, 1970. */
        //@}
    }/*}}}*/
    // private String __internal_monthName(boolean fullName, int month, Locale l);/*{{{*/
    /**
     * Get the name of a month.
     * @param fullName Boolean value defining if the full name should be
     * returned. If \b false the abreviated name will be returned.
     * @param month The month to get the name for.
     * @param l The \c Locale object to obtain the localized values.
     * @return String with the month name. If an error occurs, an empty string
     * will be returned.
     * @since 2.5
     **/
    private String __internal_monthName(boolean fullName, int month, Locale l)
    {
        String[] names;
        String result;
        java.text.DateFormatSymbols dfs;

        try {
            dfs = java.text.DateFormatSymbols.getInstance(l);
            if (fullName)
                names = dfs.getMonths();
            else
                names = dfs.getShortMonths();
            result = names[month - 1];
        }
        catch (Exception ex) {
            return strings.EMPTY;
        }
        return result;
    }/*}}}*/
    // private String __internal_weekDay(boolean fullName, int day, Locale l);/*{{{*/
    /**
     * Get the name of a day in a week.
     * @param fullName Boolean value defining if the full name should be
     * returned. If \b false the abreviated name will be returned.
     * @param day The day to get the name for. From 1 to 7.
     * @param l The \c Locale object to obtain the localized values.
     * @return String with the day name. If an error occurs, an empty string
     * will be returned.
     * @since 2.5
     **/
    private String __internal_weekDay(boolean fullName, int day, Locale l)
    {
        String[] names;
        String result;
        java.text.DateFormatSymbols dfs;

        try {
            dfs = java.text.DateFormatSymbols.getInstance(l);
            if (fullName)
                names = dfs.getWeekdays();
            else
                names = dfs.getShortWeekdays();
            result = names[day - 1];
        }
        catch (Exception ex) {
            return strings.EMPTY;
        }
        return result;
    }/*}}}*/
    // private String __internal_formatDate(Locale l);/*{{{*/
    /**
     * Retrieves the formated date according with the rule of the passed
     * locale.
     * @param l Locale to apply the format.
     * @return The formated date in a string.
     * @since 2.5
     **/
    private String __internal_formatDate(Locale l)
    {
        Date dt = new Date(m_time.get());
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, l);
        return df.format(dt);
    }/*}}}*/
    // private String __internal_formatTime(Locale l);/*{{{*/
    /**
     * Retrieves the formated time according with the rule of the passed
     * locale.
     * @param l Locale to apply the format.
     * @return The formated time in a string.
     * @since 2.5
     **/
    private String __internal_formatTime(Locale l)
    {
        Date dt = new Date(m_time.get());
        DateFormat df = DateFormat.getTimeInstance(DateFormat.SHORT, l);
        return df.format(dt);
    }/*}}}*/
    // private String __internal_formatDateTime(Locale l);/*{{{*/
    /**
     * Retrieves the formated date and time according with the rule of the
     * passed locale.
     * @param l Locale to apply the format.
     * @return The formated date and time in a string.
     * @since 2.5
     **/
    private String __internal_formatDateTime(Locale l)
    {
        Date dt = new Date(m_time.get());
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT, l);
        return df.format(dt);
    }/*}}}*/
    //@}

    /** \name Data Members */ //@{
    private time_t m_time;      /**< The hard work class.   */
    //@}
}
// vim:syntax=java.doxygen
