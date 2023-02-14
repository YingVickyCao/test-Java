package com.hades.java.example;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class TestDate {
    /**
     * Date
     */
    @Test
    public void test_Date() {
        Date date = new Date();
        // Wed Nov 10 21:24:44 CST 2021
        // 标准的UTC时间。表示当前时区的时间，带偏移量。CST就代表了偏移量 +0800
        System.err.println(date.toString());

        // @Deprecated
        // Nov 10, 2021 9:24:44 PM
        // 本地时间。表示当前时区的时间，不带偏移量。
        System.err.println(date.toLocaleString()); // GMT 标准写法


        // @Deprecated
        // 10 Nov 2021 13:24:44 GMT
        // GTM 时间。表示格林威治地方的时间
        System.err.println(date.toGMTString()); // GMT 标准写法

    }

    /**
     * 时区/偏移量TimeZone
     */
    @Test
    public void test_timezone() {
        // 1 TimeZone.getDefault()表示当前JVM运行的时区。
        // sun.util.calendar.ZoneInfo[id="Asia/Shanghai",offset=28800000,dstSavings=0,useDaylight=false,transitions=19,lastRule=null] : 在中国运行
        System.err.println(TimeZone.getDefault());


        // 2 列出所有时区
        for (String item : TimeZone.getAvailableIDs()) {
            System.err.println(item);
        }
        // (1)有的国家打印出多个时区。
        // (2)有重庆和上海但没有 Asia/Beijing
        // Asia/Chongqing // 亚洲/重庆
        // Asia/Shanghai // 亚洲/上海

        // (3)JDK不同版本输出的总个数可能存在差异，但主流的ZoneId一般不会有变化
        /**
         * Africa/Abidjan
         * Africa/Accra
         * Africa/Addis_Ababa
         * Africa/Algiers
         * Africa/Asmara
         * Africa/Asmera
         * Africa/Bamako
         * Africa/Bangui
         * Africa/Banjul
         * Africa/Bissau
         * Africa/Blantyre
         * Africa/Brazzaville
         * Africa/Bujumbura
         * Africa/Cairo
         * Africa/Casablanca
         * Africa/Ceuta
         * Africa/Conakry
         * Africa/Dakar
         * Africa/Dar_es_Salaam
         * Africa/Djibouti
         * Africa/Douala
         * Africa/El_Aaiun
         * Africa/Freetown
         * Africa/Gaborone
         * Africa/Harare
         * Africa/Johannesburg
         * Africa/Juba
         * Africa/Kampala
         * Africa/Khartoum
         * Africa/Kigali
         * Africa/Kinshasa
         * Africa/Lagos
         * Africa/Libreville
         * Africa/Lome
         * Africa/Luanda
         * Africa/Lubumbashi
         * Africa/Lusaka
         * Africa/Malabo
         * Africa/Maputo
         * Africa/Maseru
         * Africa/Mbabane
         * Africa/Mogadishu
         * Africa/Monrovia
         * Africa/Nairobi
         * Africa/Ndjamena
         * Africa/Niamey
         * Africa/Nouakchott
         * Africa/Ouagadougou
         * Africa/Porto-Novo
         * Africa/Sao_Tome
         * Africa/Timbuktu
         * Africa/Tripoli
         * Africa/Tunis
         * Africa/Windhoek
         * America/Adak
         * America/Anchorage
         * America/Anguilla
         * America/Antigua
         * America/Araguaina
         * America/Argentina/Buenos_Aires
         * America/Argentina/Catamarca
         * America/Argentina/ComodRivadavia
         * America/Argentina/Cordoba
         * America/Argentina/Jujuy
         * America/Argentina/La_Rioja
         * America/Argentina/Mendoza
         * America/Argentina/Rio_Gallegos
         * America/Argentina/Salta
         * America/Argentina/San_Juan
         * America/Argentina/San_Luis
         * America/Argentina/Tucuman
         * America/Argentina/Ushuaia
         * America/Aruba
         * America/Asuncion
         * America/Atikokan
         * America/Atka
         * America/Bahia
         * America/Bahia_Banderas
         * America/Barbados
         * America/Belem
         * America/Belize
         * America/Blanc-Sablon
         * America/Boa_Vista
         * America/Bogota
         * America/Boise
         * America/Buenos_Aires
         * America/Cambridge_Bay
         * America/Campo_Grande
         * America/Cancun
         * America/Caracas
         * America/Catamarca
         * America/Cayenne
         * America/Cayman
         * America/Chicago
         * America/Chihuahua
         * America/Coral_Harbour
         * America/Cordoba
         * America/Costa_Rica
         * America/Creston
         * America/Cuiaba
         * America/Curacao
         * America/Danmarkshavn
         * America/Dawson
         * America/Dawson_Creek
         * America/Denver
         * America/Detroit
         * America/Dominica
         * America/Edmonton
         * America/Eirunepe
         * America/El_Salvador
         * America/Ensenada
         * America/Fort_Nelson
         * America/Fort_Wayne
         * America/Fortaleza
         * America/Glace_Bay
         * America/Godthab
         * America/Goose_Bay
         * America/Grand_Turk
         * America/Grenada
         * America/Guadeloupe
         * America/Guatemala
         * America/Guayaquil
         * America/Guyana
         * America/Halifax
         * America/Havana
         * America/Hermosillo
         * America/Indiana/Indianapolis
         * America/Indiana/Knox
         * America/Indiana/Marengo
         * America/Indiana/Petersburg
         * America/Indiana/Tell_City
         * America/Indiana/Vevay
         * America/Indiana/Vincennes
         * America/Indiana/Winamac
         * America/Indianapolis
         * America/Inuvik
         * America/Iqaluit
         * America/Jamaica
         * America/Jujuy
         * America/Juneau
         * America/Kentucky/Louisville
         * America/Kentucky/Monticello
         * America/Knox_IN
         * America/Kralendijk
         * America/La_Paz
         * America/Lima
         * America/Los_Angeles
         * America/Louisville
         * America/Lower_Princes
         * America/Maceio
         * America/Managua
         * America/Manaus
         * America/Marigot
         * America/Martinique
         * America/Matamoros
         * America/Mazatlan
         * America/Mendoza
         * America/Menominee
         * America/Merida
         * America/Metlakatla
         * America/Mexico_City
         * America/Miquelon
         * America/Moncton
         * America/Monterrey
         * America/Montevideo
         * America/Montreal
         * America/Montserrat
         * America/Nassau
         * America/New_York
         * America/Nipigon
         * America/Nome
         * America/Noronha
         * America/North_Dakota/Beulah
         * America/North_Dakota/Center
         * America/North_Dakota/New_Salem
         * America/Ojinaga
         * America/Panama
         * America/Pangnirtung
         * America/Paramaribo
         * America/Phoenix
         * America/Port-au-Prince
         * America/Port_of_Spain
         * America/Porto_Acre
         * America/Porto_Velho
         * America/Puerto_Rico
         * America/Punta_Arenas
         * America/Rainy_River
         * America/Rankin_Inlet
         * America/Recife
         * America/Regina
         * America/Resolute
         * America/Rio_Branco
         * America/Rosario
         * America/Santa_Isabel
         * America/Santarem
         * America/Santiago
         * America/Santo_Domingo
         * America/Sao_Paulo
         * America/Scoresbysund
         * America/Shiprock
         * America/Sitka
         * America/St_Barthelemy
         * America/St_Johns
         * America/St_Kitts
         * America/St_Lucia
         * America/St_Thomas
         * America/St_Vincent
         * America/Swift_Current
         * America/Tegucigalpa
         * America/Thule
         * America/Thunder_Bay
         * America/Tijuana
         * America/Toronto
         * America/Tortola
         * America/Vancouver
         * America/Virgin
         * America/Whitehorse
         * America/Winnipeg
         * America/Yakutat
         * America/Yellowknife
         * Antarctica/Casey
         * Antarctica/Davis
         * Antarctica/DumontDUrville
         * Antarctica/Macquarie
         * Antarctica/Mawson
         * Antarctica/McMurdo
         * Antarctica/Palmer
         * Antarctica/Rothera
         * Antarctica/South_Pole
         * Antarctica/Syowa
         * Antarctica/Troll
         * Antarctica/Vostok
         * Arctic/Longyearbyen
         * Asia/Aden
         * Asia/Almaty
         * Asia/Amman
         * Asia/Anadyr
         * Asia/Aqtau
         * Asia/Aqtobe
         * Asia/Ashgabat
         * Asia/Ashkhabad
         * Asia/Atyrau
         * Asia/Baghdad
         * Asia/Bahrain
         * Asia/Baku
         * Asia/Bangkok
         * Asia/Barnaul
         * Asia/Beirut
         * Asia/Bishkek
         * Asia/Brunei
         * Asia/Calcutta
         * Asia/Chita
         * Asia/Choibalsan
         * Asia/Chongqing
         * Asia/Chungking
         * Asia/Colombo
         * Asia/Dacca
         * Asia/Damascus
         * Asia/Dhaka
         * Asia/Dili
         * Asia/Dubai
         * Asia/Dushanbe
         * Asia/Famagusta
         * Asia/Gaza
         * Asia/Harbin
         * Asia/Hebron
         * Asia/Ho_Chi_Minh
         * Asia/Hong_Kong
         * Asia/Hovd
         * Asia/Irkutsk
         * Asia/Istanbul
         * Asia/Jakarta
         * Asia/Jayapura
         * Asia/Jerusalem
         * Asia/Kabul
         * Asia/Kamchatka
         * Asia/Karachi
         * Asia/Kashgar
         * Asia/Kathmandu
         * Asia/Katmandu
         * Asia/Khandyga
         * Asia/Kolkata
         * Asia/Krasnoyarsk
         * Asia/Kuala_Lumpur
         * Asia/Kuching
         * Asia/Kuwait
         * Asia/Macao
         * Asia/Macau
         * Asia/Magadan
         * Asia/Makassar
         * Asia/Manila
         * Asia/Muscat
         * Asia/Nicosia
         * Asia/Novokuznetsk
         * Asia/Novosibirsk
         * Asia/Omsk
         * Asia/Oral
         * Asia/Phnom_Penh
         * Asia/Pontianak
         * Asia/Pyongyang
         * Asia/Qatar
         * Asia/Qyzylorda
         * Asia/Rangoon
         * Asia/Riyadh
         * Asia/Saigon
         * Asia/Sakhalin
         * Asia/Samarkand
         * Asia/Seoul
         * Asia/Shanghai
         * Asia/Singapore
         * Asia/Srednekolymsk
         * Asia/Taipei
         * Asia/Tashkent
         * Asia/Tbilisi
         * Asia/Tehran
         * Asia/Tel_Aviv
         * Asia/Thimbu
         * Asia/Thimphu
         * Asia/Tokyo
         * Asia/Tomsk
         * Asia/Ujung_Pandang
         * Asia/Ulaanbaatar
         * Asia/Ulan_Bator
         * Asia/Urumqi
         * Asia/Ust-Nera
         * Asia/Vientiane
         * Asia/Vladivostok
         * Asia/Yakutsk
         * Asia/Yangon
         * Asia/Yekaterinburg
         * Asia/Yerevan
         * Atlantic/Azores
         * Atlantic/Bermuda
         * Atlantic/Canary
         * Atlantic/Cape_Verde
         * Atlantic/Faeroe
         * Atlantic/Faroe
         * Atlantic/Jan_Mayen
         * Atlantic/Madeira
         * Atlantic/Reykjavik
         * Atlantic/South_Georgia
         * Atlantic/St_Helena
         * Atlantic/Stanley
         * Australia/ACT
         * Australia/Adelaide
         * Australia/Brisbane
         * Australia/Broken_Hill
         * Australia/Canberra
         * Australia/Currie
         * Australia/Darwin
         * Australia/Eucla
         * Australia/Hobart
         * Australia/LHI
         * Australia/Lindeman
         * Australia/Lord_Howe
         * Australia/Melbourne
         * Australia/NSW
         * Australia/North
         * Australia/Perth
         * Australia/Queensland
         * Australia/South
         * Australia/Sydney
         * Australia/Tasmania
         * Australia/Victoria
         * Australia/West
         * Australia/Yancowinna
         * Brazil/Acre
         * Brazil/DeNoronha
         * Brazil/East
         * Brazil/West
         * CET
         * CST6CDT
         * Canada/Atlantic
         * Canada/Central
         * Canada/Eastern
         * Canada/Mountain
         * Canada/Newfoundland
         * Canada/Pacific
         * Canada/Saskatchewan
         * Canada/Yukon
         * Chile/Continental
         * Chile/EasterIsland
         * Cuba
         * EET
         * EST5EDT
         * Egypt
         * Eire
         * Etc/GMT
         * Etc/GMT+0
         * Etc/GMT+1
         * Etc/GMT+10
         * Etc/GMT+11
         * Etc/GMT+12
         * Etc/GMT+2
         * Etc/GMT+3
         * Etc/GMT+4
         * Etc/GMT+5
         * Etc/GMT+6
         * Etc/GMT+7
         * Etc/GMT+8
         * Etc/GMT+9
         * Etc/GMT-0
         * Etc/GMT-1
         * Etc/GMT-10
         * Etc/GMT-11
         * Etc/GMT-12
         * Etc/GMT-13
         * Etc/GMT-14
         * Etc/GMT-2
         * Etc/GMT-3
         * Etc/GMT-4
         * Etc/GMT-5
         * Etc/GMT-6
         * Etc/GMT-7
         * Etc/GMT-8
         * Etc/GMT-9
         * Etc/GMT0
         * Etc/Greenwich
         * Etc/UCT
         * Etc/UTC
         * Etc/Universal
         * Etc/Zulu
         * Europe/Amsterdam
         * Europe/Andorra
         * Europe/Astrakhan
         * Europe/Athens
         * Europe/Belfast
         * Europe/Belgrade
         * Europe/Berlin
         * Europe/Bratislava
         * Europe/Brussels
         * Europe/Bucharest
         * Europe/Budapest
         * Europe/Busingen
         * Europe/Chisinau
         * Europe/Copenhagen
         * Europe/Dublin
         * Europe/Gibraltar
         * Europe/Guernsey
         * Europe/Helsinki
         * Europe/Isle_of_Man
         * Europe/Istanbul
         * Europe/Jersey
         * Europe/Kaliningrad
         * Europe/Kiev
         * Europe/Kirov
         * Europe/Lisbon
         * Europe/Ljubljana
         * Europe/London
         * Europe/Luxembourg
         * Europe/Madrid
         * Europe/Malta
         * Europe/Mariehamn
         * Europe/Minsk
         * Europe/Monaco
         * Europe/Moscow
         * Europe/Nicosia
         * Europe/Oslo
         * Europe/Paris
         * Europe/Podgorica
         * Europe/Prague
         * Europe/Riga
         * Europe/Rome
         * Europe/Samara
         * Europe/San_Marino
         * Europe/Sarajevo
         * Europe/Saratov
         * Europe/Simferopol
         * Europe/Skopje
         * Europe/Sofia
         * Europe/Stockholm
         * Europe/Tallinn
         * Europe/Tirane
         * Europe/Tiraspol
         * Europe/Ulyanovsk
         * Europe/Uzhgorod
         * Europe/Vaduz
         * Europe/Vatican
         * Europe/Vienna
         * Europe/Vilnius
         * Europe/Volgograd
         * Europe/Warsaw
         * Europe/Zagreb
         * Europe/Zaporozhye
         * Europe/Zurich
         * GB
         * GB-Eire
         * GMT
         * GMT0
         * Greenwich
         * Hongkong
         * Iceland
         * Indian/Antananarivo
         * Indian/Chagos
         * Indian/Christmas
         * Indian/Cocos
         * Indian/Comoro
         * Indian/Kerguelen
         * Indian/Mahe
         * Indian/Maldives
         * Indian/Mauritius
         * Indian/Mayotte
         * Indian/Reunion
         * Iran
         * Israel
         * Jamaica
         * Japan
         * Kwajalein
         * Libya
         * MET
         * MST7MDT
         * Mexico/BajaNorte
         * Mexico/BajaSur
         * Mexico/General
         * NZ
         * NZ-CHAT
         * Navajo
         * PRC
         * PST8PDT
         * Pacific/Apia
         * Pacific/Auckland
         * Pacific/Bougainville
         * Pacific/Chatham
         * Pacific/Chuuk
         * Pacific/Easter
         * Pacific/Efate
         * Pacific/Enderbury
         * Pacific/Fakaofo
         * Pacific/Fiji
         * Pacific/Funafuti
         * Pacific/Galapagos
         * Pacific/Gambier
         * Pacific/Guadalcanal
         * Pacific/Guam
         * Pacific/Honolulu
         * Pacific/Johnston
         * Pacific/Kiritimati
         * Pacific/Kosrae
         * Pacific/Kwajalein
         * Pacific/Majuro
         * Pacific/Marquesas
         * Pacific/Midway
         * Pacific/Nauru
         * Pacific/Niue
         * Pacific/Norfolk
         * Pacific/Noumea
         * Pacific/Pago_Pago
         * Pacific/Palau
         * Pacific/Pitcairn
         * Pacific/Pohnpei
         * Pacific/Ponape
         * Pacific/Port_Moresby
         * Pacific/Rarotonga
         * Pacific/Saipan
         * Pacific/Samoa
         * Pacific/Tahiti
         * Pacific/Tarawa
         * Pacific/Tongatapu
         * Pacific/Truk
         * Pacific/Wake
         * Pacific/Wallis
         * Pacific/Yap
         * Poland
         * Portugal
         * ROK
         * Singapore
         * SystemV/AST4
         * SystemV/AST4ADT
         * SystemV/CST6
         * SystemV/CST6CDT
         * SystemV/EST5
         * SystemV/EST5EDT
         * SystemV/HST10
         * SystemV/MST7
         * SystemV/MST7MDT
         * SystemV/PST8
         * SystemV/PST8PDT
         * SystemV/YST9
         * SystemV/YST9YDT
         * Turkey
         * UCT
         * US/Alaska
         * US/Aleutian
         * US/Arizona
         * US/Central
         * US/East-Indiana
         * US/Eastern
         * US/Hawaii
         * US/Indiana-Starke
         * US/Michigan
         * US/Mountain
         * US/Pacific
         * US/Pacific-New
         * US/Samoa
         * UTC
         * Universal
         * W-SU
         * WET
         * Zulu
         * EST
         * HST
         * MST
         * ACT
         * AET
         * AGT
         * ART
         * AST
         * BET
         * BST
         * CAT
         * CNT
         * CST
         * CTT
         * EAT
         * ECT
         * IET
         * IST
         * JST
         * MIT
         * NET
         * NST
         * PLT
         * PNT
         * PRT
         * PST
         * SST
         * VST
         */

        // (4)假如某个国家和城市并没有在TimeZone中记录。可以用时区偏移量来表示。
        System.err.println(TimeZone.getTimeZone("GMT+08:00").getID());      // 中国 GMT+08:00
        System.err.println(TimeZone.getDefault().getID());                  // 中国 Asia/Shanghai
        System.err.println(TimeZone.getTimeZone("Asia/Shanghai").getID());  // 中国 Asia/Shanghai

        System.out.println(TimeZone.getTimeZone("GMT-05:00").getID());      // 纽约
        System.out.println(TimeZone.getTimeZone("America/New_York").getID());// 纽约

        // 3 同一份代码部署在不同的时区. 怎么办法?
        // 方法 1：设置默认时区。
        // 优点：管理简单，对开发者友好。
        // 缺点：因为与当地人的时区不一样，阅读不友好。
        // Way 1
        TimeZone.setDefault(TimeZone.getTimeZone("America/New_York"));
        System.err.println(TimeZone.getDefault().getID());  // America/New_York
        // Way 2 : JVM参数方式：-Duser.timezone=GMT+8
        // Way 3 : 设置操作系统主机时区。 推荐这种方式，因为开发者不用管，运维置统设置时区。

        // 方法 2：做带时区的时间转换

    }


    /**
     * java.util.Date 表示一个特定的时间戳，单位为ms，与时区无关
     * 同一个时间戳，根据不同的时区或偏移量，来表示不同地区的时间。
     */
    @Test
    public void test_timestamp() {
//        long ms = System.currentTimeMillis();
//        System.out.println(ms); // 1637061249514

        long ms = 1637061249514L;
        String pattern = "yyyy-MM-dd HH:mm:ss";
        Date date = new Date(ms);

        DateFormat beijingDateFormat = new SimpleDateFormat(pattern);
        beijingDateFormat.setTimeZone(TimeZone.getDefault());

        DateFormat newYorkDateFormat = new SimpleDateFormat(pattern);
        newYorkDateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));

        //  timestamp is :1637061249514,北京时间：2021-11-16 19:14:09
        System.out.println("timestamp is :" + date.getTime() + ",北京时间：" + beijingDateFormat.format(date));
        //  timestamp is :1637061249514, 纽约时间：2021-11-16 06:14:09
        System.out.println("timestamp is :" + date.getTime() + ", 纽约时间：" + newYorkDateFormat.format(date));

    }

    /**
     * 格式化模型
     */
    @Test
    public void test_format_date() throws ParseException {
        {
            // 默认双方通信是同一个时间，那么DateFormat默认采用的同一个时区，双方显示的时间都没有问题。
//            String pattern = "yyyy-MM-dd HH:mm:ss";
//            String dateSting = "2021-11-16 19:14:09";// 服务器返回的时间字符串
//
//            DateFormat dateFormat = new SimpleDateFormat(pattern);
//            Date date = dateFormat.parse(dateSting);                // Asia/Shanghai
//            System.out.println(dateFormat.getTimeZone().getID());   // Tue Nov 16 19:14:09 CST 2021
//            System.out.println(date.toString());
        }

        {

            //        long ms = System.currentTimeMillis();
//        System.out.println(ms); // 1637061249514
            long ms = 1637061249514L;
            String pattern = "yyyy-MM-dd HH:mm:ss";
            String dateString = "2021-11-16 19:14:09";


            DateFormat beijingDateFormat = new SimpleDateFormat(pattern, Locale.CANADA);
            DateFormat usDateFormat = new SimpleDateFormat(pattern, Locale.US);

            // 如果发送dateString的为北京时区。接收方为美国的时区，那么由于dateString没有带时区标记，导致美国那边的时间显示有问题。
            // Tue Nov 16 19:14:09 CST 2021
            System.out.println(beijingDateFormat.parse(dateString));
            // Tue Nov 16 19:14:09 CST 2021
            System.out.println(usDateFormat.parse(dateString));
        }
    }

    /**
     * java <= 7, 同一个时间戳，得到的java.util.Date 和 java.sql.Timestamp，格式不同，但它们的时间戳long 值是相同的。
     */
    @Test
    public void test10() {
        //  long ms = System.currentTimeMillis();
        //  System.out.println(ms); // 1637061249514
        long ms = 1637061249514L;
        java.util.Date date = new Date(ms);
        System.out.println(date);               // Tue Nov 16 19:14:09 CST 2021  -> GMT
        System.out.println(date.getTime());     // 1637061249514

        java.sql.Date sqlDate = new java.sql.Date(ms);
        System.out.println(sqlDate);            // 2021-11-16
        System.out.println(sqlDate.getTime());  // 1637061249514

        java.sql.Time time = new java.sql.Time(ms);
        System.out.println(time);               // 19:14:09
        System.out.println(time.getTime());     // 1637061249514

        java.sql.Timestamp timestamp = new java.sql.Timestamp(ms);
        System.out.println(timestamp);          // 2021-11-16 19:14:09.514
        System.out.println(timestamp.getTime());// 1637061249514
    }
}
