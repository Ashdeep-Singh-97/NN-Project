
public class helper
{
	public static void initialise(Neuron input_test_data[][],Neuron output_test_data[][])
	{
		int values[] = {1,0,0,0,1,1,0,1,0,0};
		double priorities[] = {0.1,0.2,0.3,0.4,0.5,0.6,0.7,0.65,0.8,0.9};
		int index = 0;
		for(int i=0; i<input_test_data.length; i++)
		{
			for(int j=0; j<input_test_data[0].length; j++)
			{
				index = (int)Math.floor(Math.random()*10);
				input_test_data[i][j].value = values[index];
				input_test_data[i][j].priority_value = priorities[index];
			}
		}
		for(int i=0; i<output_test_data.length; i++)
		{
			for(int j=0; j<output_test_data[0].length; j++)
			{
				index = (int)Math.floor(Math.random()*10);
				output_test_data[i][j].value = values[index];
				output_test_data[i][j].priority_value = priorities[index];
			}
		}
	}
	
	public static void initialise(double[][] weights) {
		for(int i=0; i<weights.length; i++)
		{
			for(int j=0; j<weights[0].length; j++)
			{
				weights[i][j] = 1.0;
			}
		}
	}
	
	public static void train(Neuron[][] input_test_data,Neuron[][] output_test_data,double[][] weights,double learning_rate)
	{
		for(int i=0; i<input_test_data.length; i++)
		{
			for(int j=0; j<5; j++)
			{
				double value_error = input_test_data[i][j].value - output_test_data[i][j].value;
				double priority_error = input_test_data[i][j].priority_value - output_test_data[i][j].priority_value;
				for(int k=0; k<5; k++)
				{
					weights[k][j] = weights[k][j] - (double)learning_rate*(value_error+priority_error);
				}
			}
		}
	}
}
