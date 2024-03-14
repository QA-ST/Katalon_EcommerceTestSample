package sample

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class CommonCache {
	static Map<String, CacheEntry> cache = [:]

	// Method to add an item to the cache with a specified expiration time
	static void addToCache(String key, Object value, long expirationTimeMinutes) {
		long expirationTimeMillis = System.currentTimeMillis() + expirationTimeMinutes * 60 * 1000
		CacheEntry entry = createCacheEntry(value, expirationTimeMillis)
		cache[key] = entry
	}

	// Method to retrieve an item from the cache
	static Object getFromCache(String key) {
		def entry= getCacheEntry(key)
		if (entry != null && entry.isValid()) {
			return entry.value
		} else {
			removeFromCache(key)
			return null
		}
	}

	// Method to check if a key exists in the cache
	static boolean containsKey(String key) {
		return cache.containsKey(key) && cache[key].isValid()
	}

	// Method to remove an item from the cache
	static void removeFromCache(String key) {
		cache.remove(key)
	}

	// Method to clear the entire cache
	static void clearCache() {
		cache.clear()
	}

	private static CacheEntry createCacheEntry(Object value, long expirationTimeMillis) {
		return new CacheEntry(value, expirationTimeMillis)
	}

	private static CacheEntry getCacheEntry(String key) {
		CacheEntry entry = cache[key]
		return entry
	}

	// Inner class representing a cache entry with an expiration time
	static class CacheEntry {
		Object value
		long expirationTimeMillis

		CacheEntry(Object value, long expirationTimeMillis) {
			this.value = value
			this.expirationTimeMillis = expirationTimeMillis
		}

		boolean isValid() {
			return System.currentTimeMillis() < expirationTimeMillis
		}
	}
}