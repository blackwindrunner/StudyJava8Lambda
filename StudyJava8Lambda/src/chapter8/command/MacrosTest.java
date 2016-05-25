package chapter8.command;

import org.junit.Test;

public class MacrosTest {

	@Test
	public void classBasedCommand() {
		MockEditor editor = new MockEditor();
		//运行这个case，每个步骤会打印两次，一个是mock的一个不是的
		// BEGIN classBasedCommand
		Macro macro = new Macro();
		macro.record(new Open(editor));
		macro.record(new Save(editor));
		macro.record(new Close(editor));
		macro.run();
		// END classBasedCommand

		editor.check();
	}

	@Test
	public void lambdaBasedCommand() {
		MockEditor editor = new MockEditor();
		//运行这个case不会打印非mock的，因为这里传入的是一个Action接口的实现，
		//editor.open()就是Action接口的perform方法的实现，因为没写sysout
		//在close中加入sysout就可以实现和Close类perform同样的效果了
		// BEGIN lambdaBasedCommand
		Macro macro = new Macro();
		macro.record(() -> editor.open());
		macro.record(() -> editor.save());
		macro.record(() -> {editor.close();System.out.println("close");});
		macro.run();
		// END lambdaBasedCommand

		editor.check();
	}

	@Test
	public void referenceBasedCommand() {
		MockEditor editor = new MockEditor();

		// BEGIN referenceBasedCommand
		Macro macro = new Macro();
		macro.record(editor::open);
		macro.record(editor::save);
		macro.record(editor::close);
		macro.run();
		// END referenceBasedCommand

		editor.check();
	}

}
