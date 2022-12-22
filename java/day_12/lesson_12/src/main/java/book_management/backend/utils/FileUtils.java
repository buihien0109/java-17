package book_management.backend.utils;

import book_management.backend.model.Book;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileUtils {
    public static ArrayList<Book> getDataFromFile(String fileName) {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(fileName));

            // TODO : Đang có vấn đề ở đây - Lỗi khi file trống
            Type type = new TypeToken<ArrayList<Book>>(){}.getType();
            ArrayList<Book> books = gson.fromJson(reader, type);

            reader.close();
            return books;
        } catch (Exception e) {
            // e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static void setDataToFile(String fileName, Object obj) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Writer writer = Files.newBufferedWriter(Paths.get(fileName));
            gson.toJson(obj, writer);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
