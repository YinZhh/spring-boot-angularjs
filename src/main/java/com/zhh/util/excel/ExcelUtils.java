/*
package com.zhh.util.excel;

import org.springframework.util.Assert;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

*/
/**
 * @author zhh.yin
 * @version v.1.0.0
 * @description This's class description
 * @date 2018/12/22 17:41
 *//*

public class ExcelUtils {

    private static final String FILE_EXT = "xls";//文件扩展名
    private static final String TIME_FORMAT = "yyyyMMddhhmmss";//文件扩展名

    */
/**
     * excel 读取
     *
     * @param inputXLS      excel 文件流
     * @param templatesFile 模板文件路径
     * @param list          数据接收List
     * @param skipErrors    是否跳过错误
     * @return 记录excle读取结果，包括错误信息
     * @throws Exception
     *//*

    //@SuppressWarnings("JavadocReference")
    public static ExcelReadMessage readExcle(InputStream inputXLS, String templatesFile, List<?> list, boolean skipErrors) throws ExcelException {
        ExcelReadMessage readMessage;

        Assert.notNull(templatesFile, "模板文件");
        Assert.notNull(inputXLS, "上传文件");

        InputStream inputXML = null;
        try {
            inputXML = ExcelUtil.class.getResourceAsStream(templatesFile);
            XLSReader reader = ExcelReaderBuilder.buildFromXML(inputXML);
            ReaderConfig.getInstance().setSkipErrors(skipErrors);
            Map<String, Object> beans = new HashMap<String, Object>();
            beans.put("entitys", list);
            readMessage = converErrorInfos(reader.read(inputXLS, beans));
        } catch (XLSDataReadException e) {
            throw new ExcelException(500, "Excel格式不正确或数据错误!");
        } catch (Exception e) {
            throw ErrorUtils.wrap(GenericError.UNKNOWN, "excle 读取失败", e);
        } finally {
            if (inputXLS != null) {
                try {
                    inputXLS.close();
                } catch (IOException e) {
                }
            }
            if (inputXML != null) {
                try {
                    inputXML.close();
                } catch (IOException e) {
                }
            }
        }
        if (list.size() == 0) {
            throw ErrorUtils.wrap(GenericError.DATAFORMAT, "Excel格式不正确或数据为空!");
        }
        return readMessage;
    }

    */
/**
     * 默认不跳过转换错误
     *
     * @param info          上传文件对象
     * @param templatesFile 规则文件路径
     * @param list          返回实体数据
     * @return ExcleReadMessage  记录excle读取结果，包括错误信息
     * @throws GenericException
     *//*

    public static ExcelReadMessage readExcle(UploadInfo info, String templatesFile, List<?> list) throws GenericException {
        return readExcle(info.getContent(), templatesFile, list, false);
    }

    */
/**
     * @param info       上传文件对象
     * @param inputXML   excle 读入规则文件流
     * @param list       返回实体数据
     * @param skipErrors 是否跳过转换错误 当false时，发现excle错误格式，直接抛出异常
     * @return ExcleReadMessage  记录excle读取结果，包括错误信息
     * @throws GenericException
     *//*

    public static ExcelReadMessage readExcle(UploadInfo info, String templatesFile, List<?> list, boolean skipErrors) throws GenericException {
        Assert.notNull(templatesFile, "模板文件");
        Assert.notNull(info, "上传文件");
        return readExcle(info.getContent(), templatesFile, list, skipErrors);
    }

    */
/**
     * 转换错误信息
     *
     * @param readStatus
     * @return
     *//*

    private static ExcelReadMessage converErrorInfos(XLSReadStatus readStatus) {
        ExcelReadMessage readMessage = new ExcelReadMessage();
        if (readStatus != null && readStatus.getReadMessages() != null && readStatus.getReadMessages().size() != 0) {//判断是否存在错误
            @SuppressWarnings("unchecked")
            List<XLSReadMessage> messages = (List<XLSReadMessage>) readStatus.getReadMessages();
            readMessage.setReadOk(false);
            for (int i = 0; i < messages.size(); i++) {
                XLSReadMessage message = (XLSReadMessage) messages.get(i);
                readMessage.addMessage(message.getMessage()*/
/*.replace("Can't read cell ", "").replace(oldChar, newChar)*//*
);
            }
        }
        return readMessage;
    }

    */
/**
     * 按照模板写excle文件
     *
     * @param templatesFile 模板文件
     * @param beans         实体List
     * @return
     *//*

    public static Workbook writeExcleWorkbook(String templatesFile, List<?> list) {
        Assert.notNull(templatesFile, "模板文件");
        Assert.notNull(list, "导出数据");
        InputStream inputXLS = null;
        Workbook resultWorkbook = null;
        try {
            Map<String, Object> beans = new HashMap<String, Object>();
            if (list.size() == 0) {
                beans.put("Entity", list);
            } else {
                Object obj = list.get(0);
                beans.put(obj.getClass().getSimpleName(), list);
            }
            inputXLS = ExcelUtil.class.getResourceAsStream(templatesFile);
            Configuration config = new Configuration();
            XLSTransformer transformer = new XLSTransformer(config);
            resultWorkbook = transformer.transformXLS(inputXLS, beans);
        } catch (ParsePropertyException | InvalidFormatException e) {
            throw ErrorUtils.wrap(ExcleError.WRITE_ERROR);
        } finally {
            if (inputXLS != null) {
                try {
                    inputXLS.close();
                } catch (IOException e) {
                }
            }
        }
        return resultWorkbook;
    }

    */
/**
     * 按照模板写excle文件
     *
     * @param templatesFile 模板文件
     * @param beans         实体List
     * @return
     *//*

    public static DownloadInfo writeExcle(String templatesFile, List<?> list, String fileName) {
        Assert.notNull(templatesFile, "模板文件");
        Assert.notNull(list, "导出数据");
        DownloadInfo downloadInfo = new DownloadInfo();
        ByteArrayOutputStream out = null;
        try {
            Workbook resultWorkbook = ExcelUtil.writeExcleWorkbook(templatesFile, list);
            out = new ByteArrayOutputStream();
            resultWorkbook.write(out);
            downloadInfo.setOutput(out);
            downloadInfo.setContentType(FILE_EXT);
            downloadInfo.setFileName(fileName);
            downloadInfo.setSize(out.size());
            out.flush();
        } catch (IOException e) {
            throw ErrorUtils.wrap(ExcleError.WRITE_ERROR);
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                }
            }
        }
        return downloadInfo;
    }

    */
/**
     * 按照模板写excle文件
     *
     * @param inputXLS 模板文件流
     * @param beans    实体List
     * @return
     * @throws InvalidFormatException
     * @throws ParsePropertyException
     *//*

    public static DownloadInfo writeExcle(String templatesFile, List<?> list) {
        return writeExcle(templatesFile, list, "templatesFile");
    }

    public static String replaceTimestamp(String fileName) {
        return fileName + "_" + DateUtils.formatDateTime(new Date(), TIME_FORMAT, Locale.CHINA) + "." + FILE_EXT;
    }


    */
/**
     * 将map复杂对象写入excel
     *
     * @param data ExcleMapData
     * @return
     *//*

    public static Workbook writeExcleWorkbook(IExcelData data) {
        Assert.notNull(data, "导出数据");
        InputStream inputXLS = null;
        Workbook resultWorkbook = null;
        try {
            Map<String, Object> beans = new HashMap<String, Object>();
            beans.put("data", data);
            inputXLS = ExcelUtil.class.getResourceAsStream(data.getTemplate());
            ExcelTransformer transformer = new ExcelTransformer();
            if (data.getValidationData() != null) {
                transformer.add(new DropdownHelper(data.getSheetName(), data.getValidationData()));
            }
            resultWorkbook = transformer.transformXLS(inputXLS, beans);
        } catch (ParsePropertyException | InvalidFormatException e) {
            throw ErrorUtils.wrap(ExcleError.WRITE_ERROR);
        } finally {
            if (inputXLS != null) {
                try {
                    inputXLS.close();
                } catch (IOException e) {
                }
            }
        }
        return resultWorkbook;
    }

    */
/**
     * 多表单写入
     *
     * @param data ExcleMapData
     * @return
     *//*

    public static Workbook writeExcleMultipleSheetData(IExcelMultipleSheetData<IExcelData> sheetData) {
        Assert.notNull(sheetData, "导出数据");
        InputStream inputXLS = null;
        Workbook resultWorkbook = null;
        try {
            inputXLS = ExcelUtil.class.getResourceAsStream(sheetData.getTemplate());
            ExcelTransformer transformer = new ExcelTransformer();
            List<String> sheetNames = new ArrayList<String>();
            for (IExcelData data : sheetData.getSheetDatas()) {
                sheetNames.add(data.getSheetName());
                if (data.getValidationData() != null) {
                    transformer.add(new DropdownHelper(data.getSheetName(), data.getValidationData()));
                }
            }
            resultWorkbook = transformer.transformMultipleSheetsList(inputXLS, sheetData.getSheetDatas(), sheetNames, "data", null, 0);
        } catch (ParsePropertyException | InvalidFormatException e) {
            throw ErrorUtils.wrap(ExcleError.WRITE_ERROR);
        } finally {
            if (inputXLS != null) {
                try {
                    inputXLS.close();
                } catch (IOException e) {
                }
            }
        }
        return resultWorkbook;
    }
}
*/
