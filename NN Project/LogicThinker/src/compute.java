import java.util.Arrays;

//import org.graalvm.compiler.lir.Variable;

public class compute
{
	/*
	0 - add
	1 - sub
	2 - mul
	3 - div
	4 - fact
	*/
	
	public static int N = 5;
	public static Neuron input_layer[] = new Neuron[5];
	public static Neuron output_layer[] = new Neuron[5];
	public static double weight[][] = new double[5][5];
	
	public static String getString(String input_text, String test_cases, String variable)
	{
		String ans = "";
		
		int keywords[] = new int[5];
		double priority[] = new double[5];
		
		for(int i=0; i<keywords.length; i++)
		{
			keywords[i] = 0;
		}
		
		for(int i=0; i<priority.length; i++)
		{
			priority[i] = 0;
		}
		
		String[] tokens = input_text.split(" ");
		
		double temp_priority = 1;
		
		for(int i=0; i<tokens.length; i++)
		{
			if(isKeyword(tokens[i]))
			{
				int index = getIndex(tokens[i]);
				keywords[index] = 1;
				temp_priority = temp_priority / 2;
				priority[index] = temp_priority;
			}
		}
		
		makeInputLayer(keywords, priority);
		
//		for(int i=0; i<N; i++)
//		{
//			ans = ans + " " + input_layer[i].priority_value;
//		}
		
		setWeights();
		
		makeOutputLayer();
		
//		for(int i=0; i<N; i++)
//		{
//			ans = ans + " " + output_layer[i].value;
//		}
		
		ans = compute(test_cases, variable);
		
//		add factorial
		return ans;
	}
	
	public static String compute(String test_cases, String variable)
	{
		String answer = "";
		
		String tc[] = test_cases.split(" ");
		String vb[] = variable.split(" ");
		
		double temporary = 0.0;
		
		double arr[] = new double[N];
		double temp[] = new double[N];
		
		for(int i=0; i<5; i++)
		{
			arr[i] = output_layer[i].value;
			temp[i] = output_layer[i].value;
		}
		
		Arrays.sort(temp);
		
		boolean flag = true;
		
		int k = -1;
		
		for(int i=N-1; i>=0; i--)
		{
			if(temp[i] == 0)
			{
				continue;
			}
			
			int index = arrayIndex(arr,temp[i]);
			
			if(flag == true)
			{
				flag = false;
				
				if(index == 0)
				{
					// add
					temporary = Double.parseDouble(tc[0]) + Double.parseDouble(tc[1]);
				}
				else if(index == 1)
				{
					// subtract
					temporary = Double.parseDouble(tc[0]) - Double.parseDouble(tc[1]);
				}
				else if(index == 2)
				{
					// multiply
					temporary = Double.parseDouble(tc[0]) * Double.parseDouble(tc[1]);
				}
				else if(index == 3)
				{
					// divide
					temporary = Double.parseDouble(tc[0]) / Double.parseDouble(tc[1]);
				}
			}
			else
			{
				k++;
				System.out.println(k);
				if(index == 0)
				{
					// add
					temporary = temporary + Double.parseDouble(vb[k]);
				}
				else if(index == 1)
				{
					// subtract
					temporary = temporary - Double.parseDouble(vb[k]);
				}
				else if(index == 2)
				{
					// multiply
					temporary = temporary * Double.parseDouble(vb[k]);
				}
				else if(index == 3)
				{
					// divide
					temporary = temporary / Double.parseDouble(vb[k]);
				}
			}
		}
		
//		if(k != vb.length)
//		{
//			while(k != vb.length)
//			{
//				
//			}
//		}
		
		answer = "" + temporary;
		
		return answer;
	}
	
	public static int arrayIndex(double[] arr, double temp)
	{
		for(int i=0; i<N; i++)
		{
			if(temp == arr[i])
			{
				return i;
			}
		}
		
		return -1;
	}
	
	public static void makeOutputLayer()
	{
		for(int i=0; i<5; i++)
		{
			double sum = 0;
			
			for(int j=0; j<5; j++)
			{
				sum = input_layer[i].value*weight[i][j] + input_layer[i].priority_value*weight[i][j];
			}
			sum = sum / 5;
			output_layer[i] = new Neuron(sum, 0.0);
		}
	}
	
	public static void setWeights()
	{
		weight[0][0] = 0.53;
		weight[0][1] = 0.57;
		weight[0][2] = 0.51;
		weight[0][3] = 0.52;
		weight[0][4] = 0.55;
		
		weight[1][0] = 0.54;
		weight[1][1] = 0.56;
		weight[1][2] = 0.51;
		weight[1][3] = 0.49;
		weight[1][4] = 0.52;
										
		weight[2][0] = 0.58;
		weight[2][1] = 0.60;
		weight[2][2] = 0.51;
		weight[2][3] = 0.48;
		weight[2][4] = 0.54;
										
		weight[3][0] = 0.53;
		weight[3][1] = 0.59;
		weight[3][2] = 0.62;
		weight[3][3] = 0.47;
		weight[3][4] = 0.58;
										
		weight[4][0] = 0.58;
		weight[4][1] = 0.51;
		weight[4][2] = 0.52;
		weight[4][3] = 0.57;
		weight[4][4] = 0.55;
	}
	
	public static void makeInputLayer(int keywords[], double priority[])
	{
		for(int i=0; i<N; i++)
		{
			input_layer[i] = new Neuron(keywords[i],priority[i]);
		}
	}
	
	public static boolean isKeyword(String s)
	{
		if(s.equals("add") || s.equals("subtract") || s.equals("multiply") || s.equals("divide") || s.equals("factorial"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static int getIndex(String string)
	{
		if(string.equals("add"))
		{
			return 0;
		}
		else if(string.equals("subtract"))
		{
			return 1;
		}
		else if(string.equals("multiply"))
		{
			return 2;
		}
		else if(string.equals("divide"))
		{
			return 3;
		}
		else
		{
			return 4;
		}

	}
}
