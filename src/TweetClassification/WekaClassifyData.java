package TweetClassification;

import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;



public class WekaClassifyData
{
	public static void main(String[] args) throws Exception
	{
		Instances TrainDataInstances=DataSource.read("TweetARffData.arff");
		TrainDataInstances.setClassIndex(TrainDataInstances.numAttributes() - 1);
		
		String[] options = new String[1];
		options[0] = "-U";
		J48 tree = new J48();
		tree.setOptions(options); 
		tree.buildClassifier(TrainDataInstances); 
		
		
	}

}


