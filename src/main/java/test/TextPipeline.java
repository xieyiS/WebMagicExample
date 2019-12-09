package test;

import cn.hutool.core.io.FileUtil;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class TextPipeline implements Pipeline {
    private File file;
    public TextPipeline(String path) throws IOException {
        setPath(path);
    }
    public void setPath(String path) throws IOException {
        /*if (!path.endsWith(File.pathSeparator)) {
            path += File.pathSeparator;
        }*/
        this.file = new File(path);
        if(!file.exists()){
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
    }

    @Override
    public void process(ResultItems resultItems, Task task) {
        FileUtil.appendLines(resultItems.getAll().entrySet(),file,"utf-8");
        /*for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
            if (entry.getValue() instanceof Iterable) {
                Iterable value = (Iterable) entry.getValue();

                printWriter.println(entry.getKey() + ":");
                for (Object o : value) {
                    printWriter.println(o);
                }
            } else {
                printWriter.println(entry.getKey() + ":\t" + entry.getValue());
            }
        }*/
    }
}
