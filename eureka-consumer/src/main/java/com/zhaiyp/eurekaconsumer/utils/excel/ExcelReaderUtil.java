package com.zhaiyp.eurekaconsumer.utils.excel;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author ZhaiYP
 *	读取大批量excel数据表格，返回List<List<String>>类型数据
 */
public class ExcelReaderUtil {
	private static Logger logger = Logger.getLogger(ExcelReaderUtil.class.getName());
	//excel2003扩展名
    public static final String EXCEL03_EXTENSION = ".xls";
    //excel2007扩展名
    public static final String EXCEL07_EXTENSION = ".xlsx";

    public static List<List<String>> ExcelData;
    
//    public static int colCounts;
    /**
     * 每获取一条记录，即打印
     * 在flume里每获取一条记录即发送，而不必缓存起来，可以大大减少内存的消耗，这里主要是针对flume读取大数据量excel来说的
     * @param sheetName
     * @param sheetIndex
     * @param curRow
     * @param cellList
     */
    public static void sendRows(String filePath, String sheetName, int sheetIndex, int curRow, List<String> cellList) {
            StringBuffer oneLineSb = new StringBuffer();
            for (String cell : cellList) {
                oneLineSb.append(cell.trim());
                oneLineSb.append(";");
            }
            String oneLine = oneLineSb.toString()+"finish";
            String[] split = oneLine.split(";");
            List<String> rowList = Arrays.asList(split);
            @SuppressWarnings({ "unchecked", "rawtypes" })
            List<String> curList = new ArrayList(rowList);
            curList.remove("start");
            curList.remove("finish");
            ExcelData.add(curList);
    }

    /**
     * 读取大批量excel数据表格，返回List<List<String>>类型数据
     * @param fileName
     * @return
     * @throws Exception
     */
    public static List<List<String>> readExcel(String fileName) throws Exception {
    	logger.info("开始读取excel表格，路径为：" + fileName);
    	long currentTimeMillis = System.currentTimeMillis();
    	ExcelData = new ArrayList<>();
    	ExcelData.clear();
        int totalRows =0;
        if (fileName.endsWith(EXCEL03_EXTENSION)) {
            //处理excel2003文件
            ExcelXlsReader excelXls=new ExcelXlsReader();
            totalRows =excelXls.process(fileName);
        } else if (fileName.endsWith(EXCEL07_EXTENSION)) {
            //处理excel2007文件
            ExcelXlsxReader excelXlsxReader = new ExcelXlsxReader();
            totalRows = excelXlsxReader.process(fileName);
        } else {
        	logger.info("文件格式错误，fileName的扩展名只能是xls或xlsx。");
            throw new Exception("文件格式错误，fileName的扩展名只能是xls或xlsx。");
        }
        long currentTimeMillis1 = System.currentTimeMillis();
        logger.info("运行时间:"+(currentTimeMillis1-currentTimeMillis)/1000);
        logger.info("发送的总行数：" + totalRows);
		return ExcelData;
    }

    public static void main(String[] args) throws Exception {
    	long currentTimeMillis = System.currentTimeMillis();
//        String path="C:\\Users\\y****\\Desktop\\TestSample\\H_20171226_***_*****_0430.xlsx";
        String filepath = "D:\\test\\test\\5-ceshi\\test.xlsx";
//    	String filepath = "D:\\test\\shape\\土左土右清单数据.xlsx";
        List<List<String>> readExcel = ExcelReaderUtil.readExcel(filepath);
        System.out.println(ExcelData.size());
        long currentTimeMillis1 = System.currentTimeMillis();
        System.out.println("运行时间:"+(currentTimeMillis1-currentTimeMillis)/1000);
    }
}
