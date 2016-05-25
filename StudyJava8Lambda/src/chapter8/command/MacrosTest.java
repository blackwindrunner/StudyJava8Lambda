package chapter8.command;

import org.junit.Test;

public class MacrosTest {

	@Test
	public void classBasedCommand() {
		MockEditor editor = new MockEditor();
		//�������case��ÿ��������ӡ���Σ�һ����mock��һ�����ǵ�
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
		//�������case�����ӡ��mock�ģ���Ϊ���ﴫ�����һ��Action�ӿڵ�ʵ�֣�
		//editor.open()����Action�ӿڵ�perform������ʵ�֣���Ϊûдsysout
		//��close�м���sysout�Ϳ���ʵ�ֺ�Close��performͬ����Ч����
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
