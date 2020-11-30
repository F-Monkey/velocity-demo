package cn.monkey.data.util;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class CSVUtil {
    private CSVUtil() {
    }

    public static <T> List<T> read(InputStream is, Class<T> type) {
        HeaderColumnNameMappingStrategy<T> mapper = new HeaderColumnNameMappingStrategy<>();
        mapper.setType(type);
        CsvToBeanBuilder<T> builder = new CsvToBeanBuilder<T>(new InputStreamReader(is))
                .withSeparator(',')
                .withQuoteChar('\'')
                .withMappingStrategy(mapper);
        return builder.build().parse();
    }
}
