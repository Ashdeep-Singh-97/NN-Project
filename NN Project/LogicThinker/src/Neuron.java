
public class Neuron {
	
    double weights[] = {1.0,1.0,1.0,1.0,1.0};
    double gradient;
    
	double value;
	double priority_value;
	double dummy_value = 0;
	
	Neuron(int val, int p_val)
	{
		value = val;
		priority_value = p_val;
		for(int i=0; i<5; i++)
		{
			weights[i] = 1.0;
		}
	}
	
	Neuron(int val, double p_val)
	{
		value = val;
		priority_value = p_val;
		for(int i=0; i<5; i++)
		{
			weights[i] = 1.0;
		}
	}
	
	Neuron(double val, double p_val)
	{
		value = val;
		priority_value = p_val;
		for(int i=0; i<5; i++)
		{
			weights[i] = 1.0;
		}
	}
	
	public double getValue()
	{
		return value;
	}
	
	public double getPriority()
	{
		return priority_value;
	}
}
