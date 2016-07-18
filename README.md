# Overview
Gilda is a project to generate random data for test purposes, specially for big data.
The format, length, and possible values of the data are customizable according to json passed as a parameter.


# Instructions:

1. mvn clean package

2. command line:
	gilda path-json-input path-directory-output numberOfGeneratedFiles linesPerFile

For example, assuming we're in target directory: 
	./gilda /home/myuser/Desktop/input-example.json /tmp 25 1000000 

That would generate 25 outputs files of random data, with 1000000 lines each. 

3. The input Json defines format, size.. of the fields that compose each line. We use the following format: 

	[{"name":"NAME_OF_FIELD_1", "type":"TYPE_OF_FIELD_1", "length":"LENGTH_OF_FIELD_1", "values":["VALUE_1", "VALUE_2", "VALUE_3"..]},
	{"name":"NAME_OF_FIELD_2", "type":"TYPE_OF_FIELD_2", "length":"LENGTH_OF_FIELD_2", "values":["VALUE_4", "VALUE_5", "VALUE_9"..]},
	{"name":"NAME_OF_FIELD_3", "type":"TYPE_OF_FIELD_3", "length":"LENGTH_OF_FIELD_3"}]

WHERE:
	- TYPE_OF_FIELD = {"alphabetic", "alphanumeric", "decimal", "boolean", "numeric"}
	- VALUE_X = These are the values that randomly would take the field. They are optional. If we don't put them, the generation would be based on the type of field and the length.

	FOR EXAMPLE, FOR THIS JSON:
	[{"name":"conceptCode", "type":"alphabetic", "length":"12", "values":["001", "002", "003", "004"]},
	{"name":"contractCode", "type":"alphanumeric","length":"20"},
	{"name":"price", "type":"decimal","length":""},
	{"name":"checked", "type":"boolean","length":""}]

WE GET THESE KIND OF LINES:
	004;fjFi7xr8Aq0F8sGPZjFr;622299,96;false
	003;8GINBg80RMUBCwyPHMwe;30895,25;false
	001;vLsX3U0lDQRdmFfjr5D0;591158,97;true
	002;VR6wDkghisLfZ50QxrvF;156340,59;true
	003;ugvqyRHtRZ62kEperw31;669068,20;false
	003;Njqs84p0aYcacHB915pQ;305928,18;false 

Please find this example file in the resources directory.

4. The outputs are csv files.

