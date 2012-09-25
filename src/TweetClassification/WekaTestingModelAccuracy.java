package TweetClassification;

import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class WekaTestingModelAccuracy
{
	public static void main(String[] args) throws Exception
	{
		Instances TrainDataInstances=DataSource.read("TweetARffData.arff");
		Instances TestDataInstances = DataSource.read("TestTweetARffData.arff");
		TrainDataInstances.setClassIndex(TrainDataInstances.numAttributes() - 1);
		TestDataInstances.setClassIndex(TestDataInstances.numAttributes() - 1);
		
		String[] options = new String[1];
		options[0] = "-U";
		J48 tree = new J48();
		tree.setOptions(options); 
		tree.buildClassifier(TrainDataInstances); 
		
		
		Evaluation eval = new Evaluation(TestDataInstances);
		eval.evaluateModel(tree,TestDataInstances);
		System.out.println(eval.toSummaryString("\nResults\n\n", false));
	}
}
