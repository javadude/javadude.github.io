package com.javadude.javamage;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;

public abstract class AutoFileCloser {
	protected abstract void doWork() throws Throwable;
	private List<Closeable> streams = new ArrayList<Closeable>();
	protected final <T extends Closeable> T watch(T closeable) {
		streams.add(0, closeable);
		return closeable;
	}
	public AutoFileCloser(){
		Throwable pending = null;
		try {
			doWork();
		} catch (ThreadDeath t) {
			throw t;
		} catch (Throwable t) {
			pending = t;
		} finally {
			for (Closeable c : streams) {
				try {
					c.close();
				} catch (ThreadDeath t) {
					throw t;
				} catch (Throwable t) {
					// report and/or log error
					if (pending == null)
						pending = t;
				}
			}
			streams.clear();
			if (pending != null)
				if (pending instanceof RuntimeException)
					throw (RuntimeException) pending;
				else
					throw new RuntimeException(pending);
		}
	}
}

//class Example1 {
//	public static void main(String[] args) {
//		new AutoFileCloser() {
//			@Override protected void doWork() throws Throwable {
//				FileReader fr = watch(new FileReader("somefile.txt"));
//				// do something with fr
//			}
//		};
//	}
//}
