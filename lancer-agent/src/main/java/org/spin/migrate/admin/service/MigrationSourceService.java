package org.spin.migrate.admin.service;

import org.spin.core.util.file.FileUtils;
import org.spin.migrate.admin.domain.MigrationSource;
import org.spin.migrate.admin.util.MigrationSourceUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * TITLE
 * <p>DESCRIPTION</p>
 * <p>Created by xuweinan on 2020/5/23</p>
 *
 * @author xuweinan
 * @version 1.0
 */
@Service
public class MigrationSourceService {
    //    instance -> schema -> version -> source
    private Map<String, Map<String, Map<String, MigrationSource>>> sourceHashMap = new ConcurrentHashMap<>();

    public void add(MigrationSource source) {
        if (!sourceHashMap.containsKey(source.getInstance())) {
            sourceHashMap.put(source.getInstance(), new HashMap<>());
        }

        Map<String, Map<String, MigrationSource>> tmp = sourceHashMap.get(source.getInstance());

        if (!tmp.containsKey(source.getSchema())) {
            tmp.put(source.getSchema(), new HashMap<>());
        }

        Map<String, MigrationSource> versions = tmp.get(source.getSchema());

        if (versions.containsKey(source.getVersion())) {
            // 异常, 该版本已经存在
        }
        versions.put(source.getVersion(), source);

        MigrationSourceUtils.writeFile(source);
    }

    public void baseline() {
    }

    public void validate() {

    }
}
