package org.jboss.examples;

import org.jboss.examples.data.csv.CSVMeterRecord;

public interface JMSMessageSender {
	void sendCSVRecord(CSVMeterRecord record);
}