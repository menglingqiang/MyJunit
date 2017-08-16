import java.util.ArrayList;

public class TestResult {

	ArrayList<TestFail> fails;
	ArrayList<TestFail> errors;
	public TestResult() {
		fails = new ArrayList<TestFail>();
		errors = new ArrayList<TestFail>();
	}
	public void run(TestCase testCase) {
		try {
			testCase.doRun();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
