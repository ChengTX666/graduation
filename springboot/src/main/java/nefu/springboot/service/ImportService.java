package nefu.springboot.service;
import lombok.RequiredArgsConstructor;
import nefu.springboot.dox.User;
import nefu.springboot.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.*;

@Service
@RequiredArgsConstructor
public class ImportService {

    private final UserRepository userRepository;

    public List<User> importStudents(InputStream inputStream) throws Exception {
        List<User> students = new ArrayList<>();
        Workbook workbook = WorkbookFactory.create(inputStream);

        Sheet sheet = workbook.getSheetAt(0); // 获取第一张表

        for (Row row : sheet) {
            if (row.getRowNum() == 0) continue; // 跳过表头

            User user = User.builder()
                    .name(row.getCell(0).getStringCellValue())
                    .account(row.getCell(1).getStringCellValue())
                    .department(row.getCell(1).getStringCellValue())
                    .student(row.getCell(1).getStringCellValue())//第几行？？？？数字改变

                    .build();
            user.setName(row.getCell(0).getStringCellValue());


            userRepository.save(user);


        }

        workbook.close();
        return students;
    }
}
