package com.hades.java.test;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

/**
 * JSR 310
 */
public class TestDate_Java8 {

    /**
     * 有的地区有夏令时，那么它的偏移量在不同时期可能是会变的。
     * 使用API的时区比偏移量更方便。因为API内置了夏时令规则的处理，我们不关心具体是什么偏移量就能得到正确的时间。
     */
    @Test
    public void test_1() {
        {
            // Java 1.8 之前
            // sun.util.calendar.ZoneInfo[id="Asia/Shanghai",offset=28800000,dstSavings=0,useDaylight=false,transitions=19,lastRule=null]
            System.err.println(TimeZone.getDefault());
        }

        {
            // Java 1.8 之后
            // 结果一样，因为底层调用是同一个API
            // public static ZoneId systemDefault() {
            //        return_in_exception TimeZone.getDefault().toZoneId();
            //    }
            System.out.println(ZoneId.systemDefault()); // Asia/Shanghai

            //根据字符串，得到一个zoneId
            System.out.println(ZoneId.of("Asia/Shanghai"));     // Asia/Shanghai
            // Error:java.time.zone.ZoneRulesException: Unknown time-zone ID: Asia/Some
//            System.err.println(ZoneId.of("Asia/Some"));


            // 根据偏移量字符串，得到一个zoneId
            System.out.println(ZoneId.ofOffset("UTC", ZoneOffset.of("+8")).getId()); // UTC+08:00
//            System.err.println(ZoneId.ofOffset("UTC", ZoneOffset.of("+8:00")).getId()); // ERROR:java.time.DateTimeException: Invalid ID for ZoneOffset, non numeric characters found: +8:00
            System.out.println(ZoneId.ofOffset("UTC", ZoneOffset.of("Z")).getId()); // UTC

            // 从日期中获得时区
            System.err.println(ZoneId.from(ZonedDateTime.now())); // Asia/Shanghai
            System.err.println(ZoneId.from(LocalDate.now())); // ERROR:java.time.DateTimeException: Unable to obtain ZoneId from TemporalAccessor: 2021-11-22 of type java.time.LocalDate
//            System.err.println(ZoneId.from(LocalDateTime.now())); // ERROR:java.time.DateTimeException: Unable to obtain ZoneId from TemporalAccessor: 2021-11-22T19:58:02.599 of type java.time.LocalDateTime

            // 列出所有zone id
            // [Asia/Aden, America/Cuiaba, Etc/GMT+9, Etc/GMT+8, Africa/Nairobi, America/Marigot, Asia/Aqtau, Pacific/Kwajalein, America/El_Salvador, Asia/Pontianak, Africa/Cairo, Pacific/Pago_Pago, Africa/Mbabane, Asia/Kuching, Pacific/Honolulu, Pacific/Rarotonga, America/Guatemala, Australia/Hobart, Europe/London, America/Belize, America/Panama, Asia/Chungking, America/Managua, America/Indiana/Petersburg, Asia/Yerevan, Europe/Brussels, GMT, Europe/Warsaw, America/Chicago, Asia/Kashgar, Chile/Continental, Pacific/Yap, CET, Etc/GMT-1, Etc/GMT-0, Europe/Jersey, America/Tegucigalpa, Etc/GMT-5, Europe/Istanbul, America/Eirunepe, Etc/GMT-4, America/Miquelon, Etc/GMT-3, Europe/Luxembourg, Etc/GMT-2, Etc/GMT-9, America/Argentina/Catamarca, Etc/GMT-8, Etc/GMT-7, Etc/GMT-6, Europe/Zaporozhye, Canada/Yukon, Canada/Atlantic, Atlantic/St_Helena, Australia/Tasmania, Libya, Europe/Guernsey, America/Grand_Turk, US/Pacific-New, Asia/Samarkand, America/Argentina/Cordoba, Asia/Phnom_Penh, Africa/Kigali, Asia/Almaty, US/Alaska, Asia/Dubai, Europe/Isle_of_Man, America/Araguaina, Cuba, Asia/Novosibirsk, America/Argentina/Salta, Etc/GMT+3, Africa/Tunis, Etc/GMT+2, Etc/GMT+1, Pacific/Fakaofo, Africa/Tripoli, Etc/GMT+0, Israel, Africa/Banjul, Etc/GMT+7, Indian/Comoro, Etc/GMT+6, Etc/GMT+5, Etc/GMT+4, Pacific/Port_Moresby, US/Arizona, Antarctica/Syowa, Indian/Reunion, Pacific/Palau, Europe/Kaliningrad, America/Montevideo, Africa/Windhoek, Asia/Karachi, Africa/Mogadishu, Australia/Perth, Brazil/East, Etc/GMT, Asia/Chita, Pacific/Easter, Antarctica/Davis, Antarctica/McMurdo, Asia/Macao, America/Manaus, Africa/Freetown, Europe/Bucharest, Asia/Tomsk, America/Argentina/Mendoza, Asia/Macau, Europe/Malta, Mexico/BajaSur, Pacific/Tahiti, Africa/Asmera, Europe/Busingen, America/Argentina/Rio_Gallegos, Africa/Malabo, Europe/Skopje, America/Catamarca, America/Godthab, Europe/Sarajevo, Australia/ACT, GB-Eire, Africa/Lagos, America/Cordoba, Europe/Rome, Asia/Dacca, Indian/Mauritius, Pacific/Samoa, America/Regina, America/Fort_Wayne, America/Dawson_Creek, Africa/Algiers, Europe/Mariehamn, America/St_Johns, America/St_Thomas, Europe/Zurich, America/Anguilla, Asia/Dili, America/Denver, Africa/Bamako, Europe/Saratov, GB, Mexico/General, Pacific/Wallis, Europe/Gibraltar, Africa/Conakry, Africa/Lubumbashi, Asia/Istanbul, America/Havana, NZ-CHAT, Asia/Choibalsan, America/Porto_Acre, Asia/Omsk, Europe/Vaduz, US/Michigan, Asia/Dhaka, America/Barbados, Europe/Tiraspol, Atlantic/Cape_Verde, Asia/Yekaterinburg, America/Louisville, Pacific/Johnston, Pacific/Chatham, Europe/Ljubljana, America/Sao_Paulo, Asia/Jayapura, America/Curacao, Asia/Dushanbe, America/Guyana, America/Guayaquil, America/Martinique, Portugal, Europe/Berlin, Europe/Moscow, Europe/Chisinau, America/Puerto_Rico, America/Rankin_Inlet, Pacific/Ponape, Europe/Stockholm, Europe/Budapest, America/Argentina/Jujuy, Australia/Eucla, Asia/Shanghai, Universal, Europe/Zagreb, America/Port_of_Spain, Europe/Helsinki, Asia/Beirut, Asia/Tel_Aviv, Pacific/Bougainville, US/Central, Africa/Sao_Tome, Indian/Chagos, America/Cayenne, Asia/Yakutsk, Pacific/Galapagos, Australia/North, Europe/Paris, Africa/Ndjamena, Pacific/Fiji, America/Rainy_River, Indian/Maldives, Australia/Yancowinna, SystemV/AST4, Asia/Oral, America/Yellowknife, Pacific/Enderbury, America/Juneau, Australia/Victoria, America/Indiana/Vevay, Asia/Tashkent, Asia/Jakarta, Africa/Ceuta, Asia/Barnaul, America/Recife, America/Buenos_Aires, America/Noronha, America/Swift_Current, Australia/Adelaide, America/Metlakatla, Africa/Djibouti, America/Paramaribo, Europe/Simferopol, Europe/Sofia, Africa/Nouakchott, Europe/Prague, America/Indiana/Vincennes, Antarctica/Mawson, America/Kralendijk, Antarctica/Troll, Europe/Samara, Indian/Christmas, America/Antigua, Pacific/Gambier, America/Indianapolis, America/Inuvik, America/Iqaluit, Pacific/Funafuti, UTC, Antarctica/Macquarie, Canada/Pacific, America/Moncton, Africa/Gaborone, Pacific/Chuuk, Asia/Pyongyang, America/St_Vincent, Asia/Gaza, Etc/Universal, PST8PDT, Atlantic/Faeroe, Asia/Qyzylorda, Canada/Newfoundland, America/Kentucky/Louisville, America/Yakutat, Asia/Ho_Chi_Minh, Antarctica/Casey, Europe/Copenhagen, Africa/Asmara, Atlantic/Azores, Europe/Vienna, ROK, Pacific/Pitcairn, America/Mazatlan, Australia/Queensland, Pacific/Nauru, Europe/Tirane, Asia/Kolkata, SystemV/MST7, Australia/Canberra, MET, Australia/Broken_Hill, Europe/Riga, America/Dominica, Africa/Abidjan, America/Mendoza, America/Santarem, Kwajalein, America/Asuncion, Asia/Ulan_Bator, NZ, America/Boise, Australia/Currie, EST5EDT, Pacific/Guam, Pacific/Wake, Atlantic/Bermuda, America/Costa_Rica, America/Dawson, Asia/Chongqing, Eire, Europe/Amsterdam, America/Indiana/Knox, America/North_Dakota/Beulah, Africa/Accra, Atlantic/Faroe, Mexico/BajaNorte, America/Maceio, Etc/UCT, Pacific/Apia, GMT0, America/Atka, Pacific/Niue, Australia/Lord_Howe, Europe/Dublin, Pacific/Truk, MST7MDT, America/Monterrey, America/Nassau, America/Jamaica, Asia/Bishkek, America/Atikokan, Atlantic/Stanley, Australia/NSW, US/Hawaii, SystemV/CST6, Indian/Mahe, Asia/Aqtobe, America/Sitka, Asia/Vladivostok, Africa/Libreville, Africa/Maputo, Zulu, America/Kentucky/Monticello, Africa/El_Aaiun, Africa/Ouagadougou, America/Coral_Harbour, Pacific/Marquesas, Brazil/West, America/Aruba, America/North_Dakota/Center, America/Cayman, Asia/Ulaanbaatar, Asia/Baghdad, Europe/San_Marino, America/Indiana/Tell_City, America/Tijuana, Pacific/Saipan, SystemV/YST9, Africa/Douala, America/Chihuahua, America/Ojinaga, Asia/Hovd, America/Anchorage, Chile/EasterIsland, America/Halifax, Antarctica/Rothera, America/Indiana/Indianapolis, US/Mountain, Asia/Damascus, America/Argentina/San_Luis, America/Santiago, Asia/Baku, America/Argentina/Ushuaia, Atlantic/Reykjavik, Africa/Brazzaville, Africa/Porto-Novo, America/La_Paz, Antarctica/DumontDUrville, Asia/Taipei, Antarctica/South_Pole, Asia/Manila, Asia/Bangkok, Africa/Dar_es_Salaam, Poland, Atlantic/Madeira, Antarctica/Palmer, America/Thunder_Bay, Africa/Addis_Ababa, Asia/Yangon, Europe/Uzhgorod, Brazil/DeNoronha, Asia/Ashkhabad, Etc/Zulu, America/Indiana/Marengo, America/Creston, America/Punta_Arenas, America/Mexico_City, Antarctica/Vostok, Asia/Jerusalem, Europe/Andorra, US/Samoa, PRC, Asia/Vientiane, Pacific/Kiritimati, America/Matamoros, America/Blanc-Sablon, Asia/Riyadh, Iceland, Pacific/Pohnpei, Asia/Ujung_Pandang, Atlantic/South_Georgia, Europe/Lisbon, Asia/Harbin, Europe/Oslo, Asia/Novokuznetsk, CST6CDT, Atlantic/Canary, America/Knox_IN, Asia/Kuwait, SystemV/HST10, Pacific/Efate, Africa/Lome, America/Bogota, America/Menominee, America/Adak, Pacific/Norfolk, Europe/Kirov, America/Resolute, Pacific/Tarawa, Africa/Kampala, Asia/Krasnoyarsk, Greenwich, SystemV/EST5, America/Edmonton, Europe/Podgorica, Australia/South, Canada/Central, Africa/Bujumbura, America/Santo_Domingo, US/Eastern, Europe/Minsk, Pacific/Auckland, Africa/Casablanca, America/Glace_Bay, Canada/Eastern, Asia/Qatar, Europe/Kiev, Singapore, Asia/Magadan, SystemV/PST8, America/Port-au-Prince, Europe/Belfast, America/St_Barthelemy, Asia/Ashgabat, Africa/Luanda, America/Nipigon, Atlantic/Jan_Mayen, Brazil/Acre, Asia/Muscat, Asia/Bahrain, Europe/Vilnius, America/Fortaleza, Etc/GMT0, US/East-Indiana, America/Hermosillo, America/Cancun, Africa/Maseru, Pacific/Kosrae, Africa/Kinshasa, Asia/Kathmandu, Asia/Seoul, Australia/Sydney, America/Lima, Australia/LHI, America/St_Lucia, Europe/Madrid, America/Bahia_Banderas, America/Montserrat, Asia/Brunei, America/Santa_Isabel, Canada/Mountain, America/Cambridge_Bay, Asia/Colombo, Australia/West, Indian/Antananarivo, Australia/Brisbane, Indian/Mayotte, US/Indiana-Starke, Asia/Urumqi, US/Aleutian, Europe/Volgograd, America/Lower_Princes, America/Vancouver, Africa/Blantyre, America/Rio_Branco, America/Danmarkshavn, America/Detroit, America/Thule, Africa/Lusaka, Asia/Hong_Kong, Iran, America/Argentina/La_Rioja, Africa/Dakar, SystemV/CST6CDT, America/Tortola, America/Porto_Velho, Asia/Sakhalin, Etc/GMT+10, America/Scoresbysund, Asia/Kamchatka, Asia/Thimbu, Africa/Harare, Etc/GMT+12, Etc/GMT+11, Navajo, America/Nome, Europe/Tallinn, Turkey, Africa/Khartoum, Africa/Johannesburg, Africa/Bangui, Europe/Belgrade, Jamaica, Africa/Bissau, Asia/Tehran, WET, Europe/Astrakhan, Africa/Juba, America/Campo_Grande, America/Belem, Etc/Greenwich, Asia/Saigon, America/Ensenada, Pacific/Midway, America/Jujuy, Africa/Timbuktu, America/Bahia, America/Goose_Bay, America/Virgin, America/Pangnirtung, Asia/Katmandu, America/Phoenix, Africa/Niamey, America/Whitehorse, Pacific/Noumea, Asia/Tbilisi, America/Montreal, Asia/Makassar, America/Argentina/San_Juan, Hongkong, UCT, Asia/Nicosia, America/Indiana/Winamac, SystemV/MST7MDT, America/Argentina/ComodRivadavia, America/Boa_Vista, America/Grenada, Asia/Atyrau, Australia/Darwin, Asia/Khandyga, Asia/Kuala_Lumpur, Asia/Famagusta, Asia/Thimphu, Asia/Rangoon, Europe/Bratislava, Asia/Calcutta, America/Argentina/Tucuman, Asia/Kabul, Indian/Cocos, Japan, Pacific/Tongatapu, America/New_York, Etc/GMT-12, Etc/GMT-11, Etc/GMT-10, SystemV/YST9YDT, Europe/Ulyanovsk, Etc/GMT-14, Etc/GMT-13, W-SU, America/Merida, EET, America/Rosario, Canada/Saskatchewan, America/St_Kitts, Arctic/Longyearbyen, America/Fort_Nelson, America/Caracas, America/Guadeloupe, Asia/Hebron, Indian/Kerguelen, SystemV/PST8PDT, Africa/Monrovia, Asia/Ust-Nera, Egypt, Asia/Srednekolymsk, America/North_Dakota/New_Salem, Asia/Anadyr, Australia/Melbourne, Asia/Irkutsk, America/Shiprock, America/Winnipeg, Europe/Vatican, Asia/Amman, Etc/UTC, SystemV/AST4ADT, Asia/Tokyo, America/Toronto, Asia/Singapore, Australia/Lindeman, America/Los_Angeles, SystemV/EST5EDT, Pacific/Majuro, America/Argentina/Buenos_Aires, Europe/Nicosia, Pacific/Guadalcanal, Europe/Athens, US/Pacific, Europe/Monaco]
            System.out.println(ZoneId.getAvailableZoneIds());
        }
    }

    /**
     * JSR 310 中，（1）日期和时间分开（2）本地时间、带时区的时间分开
     */
    @Test
    public void test_local_date_and_time() {
        // 本地日期/时间
        System.out.println(LocalDate.now());        // 2021-11-22
        System.out.println(LocalTime.now());        // 20:05:14.083
        System.out.println(LocalDateTime.now());    // 2021-11-22T20:05:14.084
    }

    @Test
    public void test_zoned_date_and_time() {
        // 带偏移量的日期/时间
        // 使用系统时区
        System.out.println(OffsetDateTime.now());   // 2021-11-22T20:10:04+08:00
        // 指定时区
        System.out.println(OffsetDateTime.now(ZoneId.of("America/New_York")));  // 2021-11-22T07:10:04.001-05:00
        // 指定时区
        System.out.println(OffsetDateTime.now(Clock.systemUTC()));  // 2021-11-22T12:10:04.001Z


        // 带时区的日期/时间
        // 使用系统时区
        System.out.println(ZonedDateTime.now());        // 2021-11-22T20:10:03.994+08:00[Asia/Shanghai]
        // 指定时区
        System.out.println(ZonedDateTime.now(ZoneId.of("America/New_York")));        // 2021-11-22T07:10:03.998-05:00[America/New_York]
        // 指定时区
        System.out.println(LocalDateTime.now(Clock.systemUTC()));    // 2021-11-22T12:10:04

    }

    /**
     * 读取字符串是JSR 310类型
     */
    @Test
    public void parseDataString() {
        //不带时区或偏移量的字符串，要么按约定时区，要么按系统默认时区，来转换，否则转换不了。
        {
            String dataString = "2021-11-22T20:05:14.084";
            LocalDateTime dateTime = LocalDateTime.parse(dataString);
            System.out.println(dateTime); /// 2021-11-22T20:05:14.084
        }

        // 带偏移量的字符串
        {
            String dataString = "2021-11-22T20:10:04+08:00";
            OffsetDateTime dateTime = OffsetDateTime.parse(dataString);
            System.out.println(dateTime); /// 2021-11-22T20:10:04+08:00
        }

        // 带时区的字符串
        {
            String dataString = "2021-11-22T07:10:03.998-05:00[America/New_York]";
            ZonedDateTime dateTime = ZonedDateTime.parse(dataString);
            System.out.println(dateTime); /// 2021-11-22T20:10:04+08:00
        }
    }

    /**
     * JSR 310类型的格式化
     */
    @Test
    public void format() {
        // 采用默认格式化输出
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE.format(localDateTime));         // 2021-11-22
        System.out.println(DateTimeFormatter.ISO_LOCAL_TIME.format(localDateTime));         // 20:32:05.064
        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(localDateTime));    // 2021-11-22T20:32:05.064
//        System.out.println(DateTimeFormatter.ISO_OFFSET_DATE.format(localDateTime));      // ERROR:java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: OffsetSeconds


        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        System.out.println(DateTimeFormatter.ISO_OFFSET_DATE.format(offsetDateTime));       // 2021-11-22+08:00
        System.out.println(DateTimeFormatter.ISO_OFFSET_TIME.format(offsetDateTime));       // 20:36:46.953+08:00
        System.out.println(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(offsetDateTime));  // 2021-11-22T20:36:46.953+08:00

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(DateTimeFormatter.ISO_ZONED_DATE_TIME.format(zonedDateTime));    // 2021-11-22T20:34:23.885+08:00[Asia/Shanghai]

        // 自定义格式化输出
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss.SSSZ");
        System.err.println(dateTimeFormatter.format(zonedDateTime));    // 2021-11-22 20:44:29.087+0800
    }
}
