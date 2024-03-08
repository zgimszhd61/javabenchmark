package com.freedom.javacodesimple.cve;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.SerializationCodec;
import org.redisson.config.Config;

import java.util.HashSet;
import java.util.Set;


//未验证：https://mvnrepository.com/artifact/org.redisson/redisson/3.21.0
//未验证：https://github.com/redisson/redisson/commit/fe6a2571801656ff1599ef87bdee20f519a5d1fe
//未验证：https://security.snyk.io/vuln/SNYK-JAVA-ORGREDISSON-5932096
public class CVE202342809 {
    public static void main(String[] argv){
        // Configure Redisson
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://127.0.0.1:6379");

        // Define an allowlist of classes for deserialization
        Set<String> allowedClasses = new HashSet<>();
        allowedClasses.add("java.util.ArrayList");
        allowedClasses.add("com.myapp.MySafeSerializableClass");

        // Use SerializationCodec with the defined allowlist
        config.setCodec(new SerializationCodec(Thread.currentThread().getContextClassLoader(), (SerializationCodec) allowedClasses));

        // Create Redisson client with the safe configuration
        RedissonClient redisson = Redisson.create(config);

        // ... use the Redisson client for operations

        // Shutdown Redisson client
        redisson.shutdown();
    }
}
