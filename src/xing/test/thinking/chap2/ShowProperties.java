package xing.test.thinking.chap2;
/**
 * 
 * 测试于16.05.10
 * 
 * @author xxh
 *
 */
public class ShowProperties {
	public static void main(String[] args) {
		System.getProperties().list(System.out);
		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getProperty("java.library.path"));
		/*
		 -- listing properties --
		java.runtime.name=Java(TM) SE Runtime Environment
		sun.boot.library.path=C:\Program Files\Java\jdk1.8.0\jre\bin
		java.vm.version=25.0-b70
		java.vm.vendor=Oracle Corporation
		java.vendor.url=http://java.oracle.com/
		path.separator=;
		java.vm.name=Java HotSpot(TM) 64-Bit Server VM
		file.encoding.pkg=sun.io
		user.script=
		user.country=CN
		sun.java.launcher=SUN_STANDARD
		sun.os.patch.level=Service Pack 1
		java.vm.specification.name=Java Virtual Machine Specification
		user.dir=F:\workspace\CodeJava
		java.runtime.version=1.8.0-b132
		java.awt.graphicsenv=sun.awt.Win32GraphicsEnvironment
		java.endorsed.dirs=C:\Program Files\Java\jdk1.8.0\jre\li...
		os.arch=amd64
		java.io.tmpdir=C:\Users\xxh\AppData\Local\Temp\
		line.separator=
		
		java.vm.specification.vendor=Oracle Corporation
		user.variant=
		os.name=Windows 7
		sun.jnu.encoding=GBK
		java.library.path=C:\Program Files\Java\jdk1.8.0\jre\bi...
		java.specification.name=Java Platform API Specification
		java.class.version=52.0
		sun.management.compiler=HotSpot 64-Bit Tiered Compilers
		os.version=6.1
		user.home=C:\Users\xxh
		user.timezone=
		java.awt.printerjob=sun.awt.windows.WPrinterJob
		file.encoding=UTF-8
		java.specification.version=1.8
		user.name=xxh
		java.class.path=F:\workspace\CodeJava\target\classes;...
		java.vm.specification.version=1.8
		sun.arch.data.model=64
		java.home=C:\Program Files\Java\jdk1.8.0\jre
		sun.java.command=xing.test.thinking.chap2.ShowProperties
		java.specification.vendor=Oracle Corporation
		user.language=zh
		awt.toolkit=sun.awt.windows.WToolkit
		java.vm.info=mixed mode
		java.version=1.8.0
		java.ext.dirs=C:\Program Files\Java\jdk1.8.0\jre\li...
		sun.boot.class.path=C:\Program Files\Java\jdk1.8.0\jre\li...
		java.vendor=Oracle Corporation
		file.separator=\
		java.vendor.url.bug=http://bugreport.sun.com/bugreport/
		sun.cpu.endian=little
		sun.io.unicode.encoding=UnicodeLittle
		sun.desktop=windows
		sun.cpu.isalist=amd64
		xxh
		C:\Program Files\Java\jdk1.8.0\jre\bin;C:\Windows\Sun\Java\bin;C:\Windows\system32;C:\Windows;C:\Program Files (x86)\NVIDIA Corporation\PhysX\Common;C:\Windows\system32;C:\Windows;C:\Windows\System32\Wbem;C:\Windows\System32\WindowsPowerShell\v1.0\;C:\Program Files (x86)\Intel\OpenCL SDK\2.0\bin\x86;C:\Program Files (x86)\Intel\OpenCL SDK\2.0\bin\x64;F:\x\software\apache-maven-3.3.9/bin;C:\Program Files\Java\jdk1.8.0\bin;C:\Program Files\Java\jdk1.8.0\jre\bin;C:\Program Files (x86)\Git\cmd;C:\Ruby22-x64\bin;.
		  
		 */
	}
}
