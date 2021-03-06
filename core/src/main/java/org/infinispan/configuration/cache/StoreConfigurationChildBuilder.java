package org.infinispan.configuration.cache;

public interface StoreConfigurationChildBuilder<S> extends LoaderConfigurationChildBuilder<S> {

   /**
    * Configuration for the async cache store. If enabled, this provides you with asynchronous
    * writes to the cache store, giving you 'write-behind' caching.
    */
   AsyncStoreConfigurationBuilder<S> async();

   /**
    * SingletonStore is a delegating cache store used for situations when only one instance in a
    * cluster should interact with the underlying store. The coordinator of the cluster will be
    * responsible for the underlying CacheStore. SingletonStore is a simply facade to a real
    * CacheStore implementation. It always delegates reads to the real CacheStore.
    */
   SingletonStoreConfigurationBuilder<S> singletonStore();

   /**
    * If true, fetch persistent state when joining a cluster. If multiple cache stores are chained,
    * only one of them can have this property enabled. Persistent state transfer with a shared cache
    * store does not make sense, as the same persistent store that provides the data will just end
    * up receiving it. Therefore, if a shared cache store is used, the cache will not allow a
    * persistent state transfer even if a cache store has this property set to true. Finally,
    * setting it to true only makes sense if in a clustered environment, and only 'replication' and
    * 'invalidation' cluster modes are supported.
    */
   S fetchPersistentState(boolean b);

   /**
    * If true, any operation that modifies the cache (put, remove, clear, store...etc) won't be
    * applied to the cache store. This means that the cache store could become out of sync with the
    * cache.
    */
   S ignoreModifications(boolean b);

   /**
    * If true, purges this cache store when it starts up.
    */
   S purgeOnStartup(boolean b);

   /**
    * The number of threads to use when purging asynchronously.
    */
   S purgerThreads(int i);

   /**
    * If true, CacheStore#purgeExpired() call will be done synchronously
    */
   S purgeSynchronously(boolean b);

}
