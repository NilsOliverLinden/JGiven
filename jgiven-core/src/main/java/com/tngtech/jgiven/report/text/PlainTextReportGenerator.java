package com.tngtech.jgiven.report.text;

import java.io.File;
import java.io.PrintWriter;

import com.google.common.io.Files;
import com.tngtech.jgiven.impl.util.PrintWriterUtil;
import com.tngtech.jgiven.impl.util.ResourceUtil;
import com.tngtech.jgiven.report.AbstractReportConfig;
import com.tngtech.jgiven.report.AbstractReportGenerator;
import com.tngtech.jgiven.report.model.ReportModel;
import com.tngtech.jgiven.report.model.ReportModelFile;

public class PlainTextReportGenerator extends AbstractReportGenerator {

    public AbstractReportConfig createReportConfig( String... args ) {
        return new PlainTextReportConfig(args);
    }

    public void generate() {
        for( ReportModelFile reportModelFile : completeReportModel.getAllReportModels() ) {
            handleReportModel(reportModelFile.model(), reportModelFile.file());
        }
    }

    public void handleReportModel( ReportModel model, File file ) {
        String targetFileName = Files.getNameWithoutExtension( file.getName() ) + ".feature";
        PrintWriter printWriter = PrintWriterUtil.getPrintWriter( new File( config.getTargetDir(), targetFileName ) );

        try {
            model.accept( new PlainTextScenarioWriter( printWriter, false ) );
        } finally {
            ResourceUtil.close( printWriter );
        }
    }
}
