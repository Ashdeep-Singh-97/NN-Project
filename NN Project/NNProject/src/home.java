
public class home
{
	public static int N = 5;
	
	public static Neuron input_layer[] = new Neuron[N];
	public static Neuron output_layer[] = new Neuron[N];
	public static Neuron input_test_data[][] = new Neuron[100][N];
	public static Neuron output_test_data[][] = new Neuron[100][N];
	public static double weights[][] = new double[N][N];
	public static double learning_rate = 0.5;
	
	public static void main(String args[])
	{
		// initialise ip op test data & weights
		helper.initialise(input_test_data, output_test_data);
		helper.initialise(weights);
		
		// train
		helper.train(input_test_data,output_test_data,weights,learning_rate);
	}
}