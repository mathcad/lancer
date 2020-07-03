package org.spin.migrate.admin.util;

import org.spin.migrate.admin.domain.MigrationSource;

/**
 * TITLE
 * <p>DESCRIPTION</p>
 * <p>Created by xuweinan on 2020/5/23</p>
 *
 * @author xuweinan
 * @version 1.0
 */
public class MigrationSourceUtils {

    public static void writeFile(MigrationSource source) {
        String fileName = source.getInstance() + "/" + source.getSchema() + "/" + source.getVersion() + "__" + source.getTitle().replaceAll("\\s+", "_") + ".sql";
    }
}
