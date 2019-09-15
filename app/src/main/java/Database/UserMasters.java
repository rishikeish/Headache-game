package Database;

import android.provider.BaseColumns;

public final class UserMasters {

        private UserMasters(){}

        protected static class Users implements BaseColumns{

            public static final String TABLE_NAME = "USER_TABLE";
            public static final String COL_1 = "USERNAME";
            public static final String COL_2 = "PASSWORD";

        }

        protected static class Level1 implements BaseColumns{

            public static final String TABLE_NAME = "LEVEL1_TABLE";
            public static final String COL_1 = "ANSWER";


        }

        protected static class Level2 implements BaseColumns{

            public static final String TABLE_NAME = "LEVEL2_TABLE";
            public static final String COL_1 = "ANSWER";


        }

        protected static class Level3 implements BaseColumns{

            public static final String TABLE_NAME = "LEVEL3_TABLE";
            public static final String COL_1 = "ANSWER";


        }

        protected static class Level4 implements BaseColumns{

            public static final String TABLE_NAME = "LEVEL4_TABLE";
            public static final String COL_1 = "TERM";
            public static final String COL_2 = "ANSWER";

        }




}
