package org.infinispan.distexec.mapreduce;

import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.loaders.dummy.DummyInMemoryCacheStoreConfigurationBuilder;
import org.testng.annotations.Test;

/**
 * TwoNodesWithCacheLoaderMapReduceTest tests Map/Reduce functionality using two Infinispan nodes,
 * local reduce and also to verify that having values in cacheloader as well does not lead to any
 * additional key/value inclusion in map/reduce algorithm
 *
 * @author Vladimir Blagojevic
 * @since 5.2
 */
@Test(groups = "functional", testName = "distexec.mapreduce.TwoNodesWithCacheLoaderMapReduceTest")
public class TwoNodesWithCacheLoaderMapReduceTest extends BaseWordCountMapReduceTest {

   @Override
   protected void createCacheManagers() throws Throwable {
      ConfigurationBuilder builder = getDefaultClusteredCacheConfig(getCacheMode(), true);
      builder.loaders().addStore(DummyInMemoryCacheStoreConfigurationBuilder.class).storeName(getClass().getSimpleName()).purgeOnStartup(true);
      createClusteredCaches(2, cacheName(), builder);
   }
}
