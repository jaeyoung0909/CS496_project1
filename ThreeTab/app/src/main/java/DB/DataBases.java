package DB;

import android.provider.BaseColumns;

/**
 * Created by user on 2017-12-27.
 */

public class DataBases {
    public static final class CreateDB implements BaseColumns {
        public static final String NAME = "name";
        public static final String CONTACT = "contact";
        public static final String _TABLENAME = "address";
        public static final String _CREATE =
                "create table "+_TABLENAME+"("
                        +NAME+" text not null , "
                        +CONTACT+" text not null , "
                        ;
    }

}
