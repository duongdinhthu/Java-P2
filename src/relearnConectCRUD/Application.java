package relearnConectCRUD;

import relearnConectCRUD.view.View;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException, IOException {
        View view = new View();
        view.choiceMenu();
//
    }
}
