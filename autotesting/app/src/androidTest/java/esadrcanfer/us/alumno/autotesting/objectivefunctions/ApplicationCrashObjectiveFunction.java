package esadrcanfer.us.alumno.autotesting.objectivefunctions;

import android.util.Log;

import androidx.test.uiautomator.UiObjectNotFoundException;
import esadrcanfer.us.alumno.autotesting.TestCase;

public class ApplicationCrashObjectiveFunction implements ObjectiveFunction {
    @Override
    public double evaluate(TestCase test) {
        double result=0;
        try {
            test.executeBefore();
            test.executeTest();
            test.executeAfter();
        }catch(Exception e){
            result=1;
        } finally {
            try {
                Log.d("TFG", "Se ha cerrado la aplicación");
                test.executeAfter();
            } catch (UiObjectNotFoundException e1) {

            }
        }
        return result;
    }
}
