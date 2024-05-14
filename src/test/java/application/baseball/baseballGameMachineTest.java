package application.baseball;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class baseballGameMachineTest {

    @Test
    void 컴퓨터_3자리_난수_생성_테스트() {
        baseballGameMachine baseballGameMachine = new baseballGameMachine("123");

//        assertEquals(getFieldValue(baseballGameMachine, "computerNumber"), getFieldValue(baseballGameMachine, "name"), "Name fields are not equal");


    }

    private Object getFieldValue(Object obj, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true); // 필드에 접근 가능하도록 설정
        return field.get(obj);
    }
    

}