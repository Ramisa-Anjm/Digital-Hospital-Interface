import java.awt.*;
import hsa.Console;
import java.awt.Color;

public class Hospital
{
    static Console c;

    //Defining global variables
    int symptom;
    char remedy;
    
    //Method to gather input from the user based on their selection of an appropriate symptom
    public static int getSymptom ()
    {

        int symptom;

        //Output asking the user what symptom corresponds to their experience 
        c.println ("\nWhat symptom best describes your experience?");
        symptom = c.readInt ();

        //Invalid check ensuring user inputs a valid number
        while (symptom != 1 && symptom != 2 && symptom != 3)
        {
            c.print ("Please enter a number corresponding with your symptom");
            symptom = c.readInt ();
        }

        return symptom;
    }

    //Method asking user if they want an at-home remedy
    public static char getRemedy ()
    {
        char remedy;

      //Asking user if they want a remedy
        c.println ("\n\nWould you like to know an at home remedy? (y/n)");
        remedy = c.readChar ();
        //Clearing the input buffer
        c.readLine ();

        return remedy;
    }

    //Method that finishes/closes off the diagnosis portion of the code
    public static char getFeedback ()
    {
        char feedback;

        //Goodbye message giving the user different options(if they want to get a re-diagnosis or an appointment)
        c.println ("We hope you like this remedy. \n\nIf you want a re-diagnosis press any key to return to the main menu.");
        c.setTextColor (Color.red);
        c.println ("\nIf you want to book an appointment, press 'y'");
        c.setTextColor (Color.black);
        feedback = c.readChar (); // Read the single character input

        //Transfering the user to the appointment booking interface 
        if (feedback == 'y')
        {
            consultation ();
        }

        return feedback;
    }

    //Method asking the user to pick a specific symptom
    public static void border ()
    {
        c.println ("\n-----------------------------------------------------------------------\n");
        c.println ("\nHere are some specific symptoms.");
        c.setTextColor (Color.blue);
        c.print ("Please enter 1, 2 or 3 accordingly.");
        c.setTextColor (Color.black);
    }

    //Diagnosis output message
    public static void diagnosis ()
    {
        c.clear ();
        c.print ("\nFrom your symptoms you seem to have ");
    }

    //Menu portion
    public static void main (String[] args)
    {
        c = new Console ();

        char choice;

        do
        {
            c.clear ();

            //Output giving the user their options between the diagnosis, appointment, and games
            c.setCursor (3, 20);
            c.setTextColor (Color.blue);
            c.println (" --- Welcome to the Online Hospital! ---");
            c.setTextColor (Color.black);
            c.setCursor (5, 30);
            c.println ("Would you like to ... ");
            c.setCursor (7, 30);
            c.println ("1. Get an Online Diagnosis");
            c.setCursor (8, 30);
            c.println ("2. Book an Appointment");
            c.setCursor (9, 30);
            c.println ("3. Games");
            c.setCursor (10, 30);
            c.println ("0. Quit");

            choice = c.getChar ();

            if (choice == '1')
                medBot ();
            else if (choice == '2')
                consultation ();
            else if (choice == '3')
                games ();
        }

        //Goodbye Message
        while (choice != '0');
        c.println ("\nThank you for using my program! Have a great day!");

    }

    //Diagnosis portion of the program
    public static void medBot()
    {
        c.clear ();

        //Define local variables
        char start, remedy, feedback;
        int choice, symptom;
        
        //Print Welcome message
        c.setCursor (3, 22);
        c.setTextColor (Color.blue);
        c.println ("Welcome to MedBot, your online doctor!");
        c.setTextColor (Color.black);
        c.println ("\nToday I will be asking about your symptoms and giving you a diagnosis, accordingly. Please note that this program is not 100% accurate and errors may occur. You will be able to book an actual appointment with your doctor after we have diagnosed you.");
        c.setCursor (9, 22);
        c.println ("\nSo now, are you ready to start your healing journey? (y/n)");
        start = c.readChar ();
        
        //If the user wants to continue on with the diagnosis after explaining how it works, if the user enters no then they will be redirected to the main menu
            if (start == 'y' || start == 'Y')
            {
                c.clear ();
                c.setCursor (4, 3);
                //Ask user what type of health issue their struggling with
                c.println ("Do you feel like you are struggling with a: \n\n1. Mental Health issue \n2. Physical Health issue \n\nPlease enter 1 or 2 correspondingly: ");
                choice = c.readInt ();

            //If the user chooses 1, they are directed to the mental health portion of the code 
                if (choice == 1)
                {
                    c.clear ();

                //Introduction message + asking the user some specific symptoms 
                    c.setCursor (4, 3);
                    c.print ("This program is based on general symptoms patients may experience. Please enter the corresponding number that best fits your symptom:");
                    c.println ("\n\n1. Anxiety \n2. Hallucination\n3. Sadness");
                    symptom = getSymptom ();

                //If the user selects a symptom, we ask them even more specific symptoms that fall under the previous symptom they selected
                    if (symptom == 1)
                    {
                        border ();
                //Outputting the even more specific symptoms 
                        c.println ("\n1. Constant fear \n2. Compulsive Behavior \n3. Flashbacks from intrusive memories");
                //Calling method to read the user input
                        symptom = getSymptom ();

                //Depending on the symptom they select we give them an appropriate diagnosis
                        if (symptom == 1)
                        {
                    //Calling method to output diagnosis message
                            diagnosis ();
                    //Outputting the diagnosis and its brief description
                            c.setTextColor (Color.green);
                            c.print ("Generalized Anxiety Disorder (GAD)");
                            c.setTextColor (Color.black);
                            c.println ("\n\nGAD is an anxiety disorder characterized by constant worry about everyday situations, despite there being no need for concern. Individuals with GAD often struggle to control their anxiety, which heavily interferes with daily life. Symptoms of GAD include restlessness, sleep problems, difficulty concentrating, and overthinking.");
                     //Calling method to ask users if they want an at-home remedy 
                            remedy = getRemedy ();

                    //If the user wants a remedy, we give it to them along with a brief description on how it helps 
                            if (remedy == 'y' || remedy == 'Y')
                            {
                                c.print ("\nYou can treat GAD by getting a");
                                c.setTextColor (Color.blue);
                                c.print ("healthier lifestyle");
                                c.setTextColor (Color.black);
                                c.print (" - eating healthily, doing meditation exercises, and working out can drastically change your thinking and behaviours as they help you manage your stress.");
                        //Closing message giving the user the option to get a rediagnosis, or book an appointment 
                                feedback = getFeedback ();
                            }
                        }

                //Depending on the symptom they select we give them an appropriate diagnosis
                        if (symptom == 2)
                        {
                        //Calling method to output diagnosis message
                            diagnosis ();
                        //Outputting the diagnosis and its brief description
                            c.setTextColor (Color.green);
                            c.print ("Obsessive Compulsive Disorder (OCD)");
                            c.setTextColor (Color.black);
                            c.print ("\nOCD is a mental health disorder characterized by repetitive actions (compulsions), or obsessions (thoughts) that make individuals feel a strong urge to respond to. When individuals experience these obsessions that create feelings of anxiety, the compulsions are done to help reduce that anxiety. Oftentimes, individuals have no control over their obsessions despite them being irrational. Symptoms those with OCD experience may include frequent checking, repetitive hand washing, or constant counting.");
                     //Calling method to ask users if they want an at-home remedy 
                            remedy = getRemedy ();

     //If the user wants a remedy, we give it to them along with a brief description on how it helps 
                            if (remedy == 'y' || remedy == 'Y')
                            {
                                c.print ("\nCreating a ");
                                c.setTextColor (Color.blue);
                                c.print ("well-structured routine");
                                c.setTextColor (Color.black);
                                c.print ("can be extremely beneficial for those with OCD. It can reduce the need to have obsessions and compulsions, giving a sense of control over your actions, and helping to relieve stress. A routine can include establishing habits like working out (helps time yourself), meditation, and bedtime, however, it is important to create a routine that works best for you because if not, it may create more OCD behaviours.");
        //Closing message giving the user the option to get a rediagnosis, or book an appointment 
                                feedback = getFeedback ();
                            }
                        }

                 //Depending on the symptom they select we give them an appropriate diagnosis
                        if (symptom == 3)
                        {
                    //Calling method to output diagnosis message
                            diagnosis ();
                    //Outputting the diagnosis and its brief description
                            c.setTextColor (Color.green);
                            c.println ("Post Traumatic Stress Disorder (PTSD)");
                            c.setTextColor (Color.black);
                            c.println ("\nPTSD is a mental health disorder that is triggered by severe stress indicators like a traumatic event or experience - caused due to being unable to confront the stress. Those with PTSD often relive their trauma through vivid flashbacks, intrusive thoughts, or even nightmares. Symptoms include paranoid, insomnia, a shift in behaviour, and emotional damage.");
                    //Calling method to ask users if they want an at-home remedy 
                            remedy = getRemedy ();

     //If the user wants a remedy, we give it to them along with a brief description on how it helps
                            if (remedy == 'y' || remedy == 'Y')
                            {
                                c.setTextColor (Color.blue);
                                c.print ("Journaling");
                                c.setTextColor (Color.black);
                                c.print ("is a constructive way to try to reduce the impacts of PTSD on your life. It can help you release your emotions in the form of writing as it can be hard for some to say it out loud, allows you to reflect and understand your feelings, helps monitor your triggers/symptoms, and comes up with coping strategies. Though journaling is beneficial in a sense, those with PTSD should take therapy as oftentimes, PTSD can lead to other disorders like depression.");
                         //Closing message giving the user the option to get a rediagnosis, or book an appointment
                                feedback = getFeedback ();
                            }
                        }
                    }

                          //If the user selects one symptom, we ask them even more specific symptoms that fall under the previous symptom they selected 
        if (symptom == 2)
                    {
                        border ();
//Outputting the even more specific symptoms 
                        c.println ("1. Auditory Hallucinations \n2. Visual Hallucinationhs \n 3. Tactile (touch) Hallucinations");
                //Calling method to read the user input
                        symptom = getSymptom ();

//Depending on the symptom they select we give them an appropriate diagnosis
                        if (symptom == 1)
                        {
                    //Calling method to output diagnosis message
                            diagnosis ();
                     //Outputting the diagnosis and its brief description
                            c.setTextColor (Color.green);
                            c.println ("Bipolar Disorder");
                            c.setTextColor (Color.black);
                            c.println ("\nBipolar disorder is a type of mental health disorder characterized by extreme mood swings or episodes of Mania. During their episodes, individuals will feel easily overwhelmed, irritable, and will often have impulsive thoughts and engage in risky behaviours. Symptoms after these episodes of Mania include sadness and fatigue. Those with bipolar disorder are known to be more vulnerable to being depressed mainly due to the episodes.");
                    //Calling method to ask users if they want an at-home remedy 
                            remedy = getRemedy ();

                    //If the user wants a remedy, we give it to them along with a brief description on how it helps 
                            if (remedy == 'y' || remedy == 'Y')
                            {
                                c.println ("Though treating bipolar disorder involves therapy and medications, you can also try to change your life in a way that ");
                                c.setTextColor (Color.blue);
                                c.print ("reduces your stress levels. ");
                                c.setTextColor (Color.black);
                                c.print ("Stress management is crucial to treat Bipolar, it helps reduce the cause of extreme mood swings and episodes of mania. This includes meditation exercises, workouts, and following a set routine. You can also try to avoid the consumption of any caffeinated products as it can disrupt your sleeping patterns leading to possible episodes of mania.");
                               //Closing message giving the user the option to get a rediagnosis, or book an appointment
feedback = getFeedback ();
                            }
                        }

                //Depending on the symptom they select we give them an appropriate diagnosis
                        if (symptom == 2)
                        {
                    //Calling method to output diagnosis message
                            diagnosis ();
                    //Outputting the diagnosis and its brief description
                            c.setTextColor (Color.green);
                            c.print ("Schitzophrenia");
                            c.setTextColor (Color.black);
                            c.println("\nSchizophrenia is a type of mental health disorder which impacts a person's way of thinking, behaviours, and emotions. Individuals diagnosed with this disorder often experience symptoms like paranoia, hallucinations, emotional distress, risky behaviour, and difficulty differentiating between reality and imaginations. These symptoms affect a person's way of living drastically and make it difficult to be able to live independently.");
                    //Calling method to ask users if they want an at-home remedy 
                            remedy = getRemedy ();

    //If the user wants a remedy, we give it to them along with a brief description on how it helps 
                            if (remedy == 'y' || remedy == 'Y')
                            {
                                c.print("An important remedy for schizophrenia is having a ");
                                c.setTextColor (Color.blue);
                                c.print("strong support system ");
                                c.setTextColor (Color.black);
                                c.print("around you and being in a safe environment. The main cause of Schizophrenia comes from things such as stress, however, if you can create a calm, well maintained living space, it can help create a sense of protection for yourself, reduce the cause of hallucinations, and emotional distress. However, the best way to treat Schizophrenia involves medications and therapy.");
        //Closing message giving the user the option to get a rediagnosis, or book an appointment
                                feedback = getFeedback ();
                            }
                        }

                       //Depending on the symptom they select we give them an appropriate diagnosis
 if (symptom == 3)
                        {
                    //Calling method to output diagnosis message
                            diagnosis ();
                    //Outputting the diagnosis and its brief description
                            c.setTextColor (Color.green);
                            c.print ("Drug abuse");
                            c.setTextColor (Color.black);
                            c.println("\nDrug abuse is a type of disorder characterized by the addiction to consuming drugs or substances. This includes the constant craving to use drugs and inability to control usage. Individuals suffering with this issue often experience heightened senses, hallucinations, memory loss, and harmful effects in different organs of the body. This issue is known to stem from mainly stress factors like rough upbringing and many other mental health disorders like depression.");
                    //Calling method to ask users if they want an at-home remedy 
                            remedy = getRemedy ();

     //If the user wants a remedy, we give it to them along with a brief description on how it helps
                            if (remedy == 'y' || remedy == 'Y')
                            {
                                c.print("A helpful remedy for drug abuse can be something as simple as ");
                                c.setTextColor (Color.blue);
                                c.print("adopting new hobbies ");
                                c.setTextColor (Color.black);
                                c.print("and consuming proper nutritions. It's extremely helpful to engage in plenty of activities like sports, painting, etc., as a way to distract yourself from the craving for drugs and also help reduce any stress factors. Establishing a proper balanced diet can help your overall mood, energy, and also help you recover from the harmful effects of drugs. ");
                        //Closing message giving the user the option to get a rediagnosis, or book an appointment
                                feedback = getFeedback ();
                            }
                        }
                    }

//If the user selects one symptom, we ask them even more specific symptoms that fall under the previous symptom they selected
                    if (symptom == 3)
                    {
                        border ();
                //Outputting the even more specific symptoms
                        c.println ("1. Change in eating habits \n2. Laziness \n 3. Suicidal Thoughts");
                //Calling method to read the user input
                        symptom = getSymptom ();

//Depending on the symptom they select we give them an appropriate diagnosis
                        if (symptom == 1)
                        {
                     //Calling method to output diagnosis message
                            diagnosis ();
                    //Outputting the diagnosis and its brief description
                            c.setTextColor (Color.green);
                            c.print ("Eating disorder");
                            c.setTextColor (Color.black);
                            c.println("Eating disorder is a mental health disorder that leads to abnormal eating behaviors, significantly impacting physical and mental well-being. Symptoms include anorexia, binge eating, and obesity, where individuals may eat excessively or restrict food intake. These behaviors are often linked to factors such as intense stress, insecurities, or trauma, and can result in severe health consequences if left untreated.");
                    //Calling method to ask users if they want an at-home remedy
                            remedy = getRemedy ();

                    //If the user wants a remedy, we give it to them along with a brief description on how it helps 
                            if (remedy == 'y' || remedy == 'Y')
                            {
                                c.print("A beneficial remedy for eating disorders can include ");
                                c.setTextColor (Color.blue);
                                c.print("establishing a balanced meal plan ");
                                c.setTextColor (Color.black);
                                c.print("which can be easy to follow. It can help control your food intake, which ensures the body receives the nutrients it needs while also reducing unhealthy eating patterns. A routined approach to meals creates a sense of stability and control, which supports both physical recovery and emotional well-being.");
       //Closing message giving the user the option to get a rediagnosis, or book an appointment
                                feedback = getFeedback ();
                            }
                        }

                       //Depending on the symptom they select we give them an appropriate diagnosis      
if (symptom == 2)
                        {
                     //Calling method to output diagnosis message
                            diagnosis ();
                     //Outputting the diagnosis and its brief description
                            c.setTextColor (Color.green);
                            c.print ("Depression");
                            c.setTextColor (Color.black);
                            c.println("\nDepression is a mental health disorder which negatively impacts your way of thinking, feeling, and behaving. Individuals with depression often experience being easily fatigued, overanalyzing every action or thought, feeling empty, and even isolating yourself. Depression is caused from several stress factors like bad family dynamics, bullying in school, work/school performance, or other mental disorders and relationship issues.");
                    //Calling method to ask users if they want an at-home remedy 
                            remedy = getRemedy ();

                    //If the user wants a remedy, we give it to them along with a brief description on how it helps
                            if (remedy == 'y' || remedy == 'Y')
                            {
                                c.print("A remedy for depression can involve ");
                                c.setTextColor (Color.blue);
                                c.print("connecting with loved ones ");
                                c.setTextColor (Color.black);
                                c.print("and adopting a healthy lifestyle. Spending time with supportive family and friends can help provide emotional comfort and reduce any negative feeling. Maintaining a balanced lifestyle by working out and engaging in many activities can help improve mood and your overall well-being.");
        //Closing message giving the user the option to get a rediagnosis, or book an appointment
                                feedback = getFeedback ();
                            }
                        }

//Depending on the symptom they select we give them an appropriate diagnosis
                        if (symptom == 3)
                        {
                            c.println ("Help is available. Please contact this suicide prevention hotline: ");
                            c.setTextColor (Color.blue);
                            c.print ("9-8-8 ");
                            c.setTextColor (Color.black);

                        }
                    }
                }

            //If the user chooses option 2 then they are struggling with a physical health issue
                if (choice == 2)
                {
                    c.clear ();
                //Output a brief description and provide possible symptoms
                    c.print ("This program is based on general symptoms patients may experience. Please enter the corresponding number that best fits your symptom");
                    c.println ("\n1. Muscle Pain \n2. Internal Pain \n3. Neuropathic Pain");
                    symptom = getSymptom ();

                //If the user selects a symptom, we ask them even more specific symptoms that fall under the previous symptom they selected
                    if (symptom == 1)
                    {
                        border ();
                //Outputting the even more specific symptoms 
                        c.println ("\n1. chronic pain \n2. short term pain \n 3. Spasms");
                //Calling method to read the user input
                        symptom = getSymptom ();

                //Depending on the symptom they select we give them an appropriate diagnosis
                        if (symptom == 1)
                        {
                    //Calling method to output diagnosis message
                            diagnosis ();
                    //Outputting the diagnosis and its brief description
                            c.setTextColor (Color.green);
                            c.print ("Cancer");
                            c.setTextColor (Color.black);
                            c.println("\nCancer is a health disease caused by abnormal cells dividing uncontrollably and spreading into nearby tissues, affecting various parts of the body. It is often caused from genetic mutations (inherited), infections, drug abuse, or prolonged exposure to harmful substances. If it is left untreated, it can disrupt the body's normal functions and cause worse consequences.");
                //Calling method to ask users if they want an at-home remedy 
                            remedy = getRemedy ();

                    //If the user wants a remedy, we give it to them along with a brief description on how it helps
                            if (remedy == 'y' || remedy == 'Y')
                            {
                                c.println ("There is no at-home remedy for this, please go to the doctors immedietly");
                        //Closing message giving the user the option to get a re-diagnosis, or book an appointment
                                feedback = getFeedback ();
                            }
                        }

                //Depending on the symptom they select we give them an appropriate diagnosis
                        if (symptom == 2)
                        {
                    //Calling method to output diagnosis message
                            diagnosis ();
                    //Outputting the diagnosis and its brief description
                            c.setTextColor (Color.green);
                            c.print ("Infection");
                            c.setTextColor (Color.black);
                            c.println("An infection occurs when harmful germs, such as bacteria, viruses, fungi, or parasites, invade the body and multiply, potentially causing illness. These microorganisms disrupt normal bodily functions and trigger the immune system to respond. Individuals with infections experience symptoms like fever, fatigue, aches, or inflammation.");
                     //Calling method to ask users if they want an at-home remedy 
                            remedy = getRemedy ();

//If the user wants a remedy, we give it to them along with a brief description on how it helps 
                            if (remedy == 'y' || remedy == 'Y')
                            {
                                c.println ("A remedy for short-term pain caused by an infection involves taking");
                                c.setTextColor (Color.blue);
                                c.print("prescribed antibiotics and staying hydrated");
                                c.setTextColor (Color.black);
                                c.print(" to help flush the infection out of your system. Antibiotics help eliminate harmful bacteria and support the body's natural detoxification process.");
         //Closing message giving the user the option to get a rediagnosis, or book an appointment 
                                feedback = getFeedback ();
                            }
                        }

//Depending on the symptom they select we give them an appropriate diagnosis
                        if (symptom == 3)
                        {
                    //Calling method to output diagnosis message
                            diagnosis ();
                    //Outputting the diagnosis and its brief description
                            c.setTextColor (Color.green);
                            c.print ("dehydration");
                            c.setTextColor (Color.black);
                            c.print("\nDehydration occurs when the body lacks adequate water to function properly. It can result from losing excessive water through sweating during exercise, severe diarrhea, vomiting, or as a side effect of certain medications. Common symptoms of dehydration include severe dizziness, headaches, dry mouth, fatigue, and muscle cramps.");
                    //Calling method to ask users if they want an at-home remedy 
                            remedy = getRemedy ();

                    //If the user wants a remedy, we give it to them along with a brief description on how it helps
                            if (remedy == 'y' || remedy == 'Y')
                            {
                                c.println ("A simple remedy for dehydration is to replenish the body by ");
                                c.setTextColor (Color.blue);
                                c.print("drinking plenty of water ");
                                c.setTextColor (Color.black);
                                c.print("(H2O). Staying hydrated by sipping water throughout the day and increasing intake during activities like exercise or in hot weather can help restore fluid balance. For severe dehydration, electrolyte-rich drinks may also be beneficial in replenishing lost minerals and fluids.");
                        //Closing message giving the user the option to get a rediagnosis, or book an appointment
                                feedback = getFeedback ();
                            }
                        }

                    }
                        //If the user selects one symptom, we ask them even more specific symptoms that fall under the previous symptom they selected  
        if (symptom == 2)
                    {
                        border ();
//Outputting the even more specific symptoms 
                        c.println ("Here are some specific symptoms for Internal Pain. Please enter 1, 2 or 3 accordingly.\n1. Abdominal Pressure \n2. Burning Pain \n 3. Chest pain");
//Calling method to read the user input
                        symptom = getSymptom ();

                //Depending on the symptom they select we give them an appropriate diagnosis
                        if (symptom == 1)
                        {
                    //Calling method to output diagnosis message
                            diagnosis ();
                    //Outputting the diagnosis and its brief description
                            c.setTextColor (Color.green);
                            c.println ("bloated/constipation");
                            c.setTextColor (Color.black);
                            c.println("\nConstipation occurs when individuals experience abnormal bowel movements and the difficulty of passing stool. Individuals with constipation often experience bloating, gastritis, feeling of blockage, constant abdominal pain/discomfort, straining during bowel movements, and hard or painful stools. This is often caused by lack of hydration, low fiber intake, or certain medication. If individuals struggle with constipation constantly, they are more vulnerable to hemorrhoids or anal complications.");
                    //Calling method to ask users if they want an at-home remedy 
                            remedy = getRemedy ();

                    //If the user wants a remedy, we give it to them along with a brief description on how it helps 
                            if (remedy == 'y' || remedy == 'Y')
                            {
                                c.print("Best way to reduce constipation is ");
                                c.setTextColor (Color.blue);
                                c.print("increasing the fiber intake ");
                                c.setTextColor (Color.black);
                                c.print("in your diet - it helps soften up your stool allowing it to pass easily. Foods that include high amounts of fiber are fruits, vegetables, legumes, or whole grains. However, if unable to consume sufficient fiber through these foods, a product like Restorolax is another beneficial alternative. Restoralax is a powder-laxative that is mixed by water and is taken once a day.");
                               //Closing message giving the user the option to get a rediagnosis, or book an appointment
 feedback = getFeedback ();
                            }
                        }

//Depending on the symptom they select we give them an appropriate diagnosis
                        if (symptom == 2)
                        {
                    //Calling method to output diagnosis message
                            diagnosis ();
                    //Outputting the diagnosis and its brief description
                            c.setTextColor (Color.green);
                            c.println ("ulcer");
                            c.setTextColor (Color.black);
                            c.print("Peptic ulcer disease occurs in the stomach or small intestines. These types of ulcers are often caused due to infections within the stomach or due to certain medications. Individuals with peptic ulcer disease often experience discomfort, burning pain, or irritation in the affected area. Other symptoms include struggling with constipation, bleeding or blockage in the anus.");
                    //Calling method to ask users if they want an at-home remedy 
                            remedy = getRemedy ();

                    //If the user wants a remedy, we give it to them along with a brief description on how it helps
                            if (remedy == 'y' || remedy == 'Y')
                            {
                                c.print("An at home remedy to treat peptic ulcer is ");
                                c.setTextColor (Color.blue);
                                c.print("honey. ");
                                c.setTextColor (Color.black);
                                c.print("The best recommended dosage is consuming 1-2 teaspoons of honey during the morning. It helps reduce any irritation and fight off any bacteria in the stomach or intestines. However, for those experiencing intense stomach pain for ulcers, it is recommended to get it checked out by a doctor as it may lead to something worse, if left untreated.");
                         //Closing message giving the user the option to get a rediagnosis, or book an appointment
                                feedback = getFeedback ();
                            }
                        }
//Depending on the symptom they select we give them an appropriate diagnosis
                        if (symptom == 3)
                        {
                    //Calling method to output diagnosis message
                            diagnosis ();
    //Outputting the diagnosis and its brief description
                            c.setTextColor (Color.green);
                            c.println ("angina ");
                            c.setTextColor (Color.black);
                            c.print("Angina is a health issue which occurs in the chest leading to severe chest pain due to the lack of oxygenated blood entering the heart. The main cause of Angina is from a heart disease which is when the arteries become clogged and narrow due a build-up of fat in the area. The buildup is often caused by high levels of consumption of sodium, fat, or cholesterol. Other factors that could lead to Angina is intense stress which has a significant impact on the body's blood pressure.");
                            //Calling method to ask users if they want an at-home remedy 
                            remedy = getRemedy ();

                     //If the user wants a remedy, we give it to them along with a brief description on how it helps
                            if (remedy == 'y' || remedy == 'Y')
                            {
                                c.print("The best way to treat Angina is ");
                                c.setTextColor (Color.blue);
                                c.print("reducing sodium or cholesterol intake ");
                                c.setTextColor (Color.black);
                                c.print("in your diet. This means reducing the consumption of processed, canned, or fast foods that include high amounts of oil or sodium. Additionally it is important to be physically active (exercising) and being mentally stable which help maintain a stable heart beat and blood flow. ");
      //Closing message giving the user the option to get a rediagnosis, or book an appointment
                                feedback = getFeedback ();
                            }
                        }
                    }
//If the user selects one symptom, we ask them even more specific symptoms that fall under the previous symptom they selected
                    if (symptom == 3)
                    {
                        border ();
                //Outputting the even more specific symptoms
                        c.println ("Here are some specific symptoms for Neuropathic Pain. Please enter 1, 2 or 3 accordingly.\n1. Intense headaches \n2. Numbness \n 3. Pain in amputated limb");
                        //Calling method to read the user input
symptom = getSymptom ();

                //Depending on the symptom they select we give them an appropriate diagnosis
                        if (symptom == 1)
                        {
                     //Calling method to output diagnosis message
                            diagnosis ();
    //Outputting the diagnosis and its brief description
                            c.setTextColor (Color.green);
                            c.println ("You have migraines");
                            c.setTextColor (Color.black);
                            c.println("\nMigraines are severe headaches that are characterized by a constant throbbing pain on one side of the head. Individuals with migraines often experience vomiting and sensitivity to light or sound. Usually migraines last for hours but at times it can last for days making it difficult to continue on with daily activities.");
                            //Calling method to ask users if they want an at-home remedy
    remedy = getRemedy ();

    //If the user wants a remedy, we give it to them along with a brief description on how it helps 
                            if (remedy == 'y' || remedy == 'Y')
                            {
                                c.println ("The most beneficial remedy for migraines is ");
                                c.setTextColor (Color.blue);
                                c.print("stress management. ");
                                c.setTextColor (Color.black);
                                c.print("Migraines or headaches are often caused due to an intense amount of stress, which is why it is important to create a routine that reduces stress and also allows you to meditate/exercise. However, for those with severe migraines, it's best to take migraine medications to help manage the pain.");
                        //Closing message giving the user the option to get a rediagnosis, or book an appointment
                                feedback = getFeedback ();
                            }
                        }

//Depending on the symptom they select we give them an appropriate diagnosis      
                        if (symptom == 2)
                        {
                     //Calling method to output diagnosis message
                            diagnosis ();
                    //Outputting the diagnosis and its brief description
                            c.setTextColor (Color.green);
                            c.println ("You have Complete Numbness");
                            c.setTextColor (Color.black);
                            c.println("\nComplete numbness is a neuropathic pain where a part of the body loses its sensations. Individuals with numbness often experience feelings of tingling, or 'sleepiness' in the part of the body. Numbness usually happens in a specific part of the body and is caused due to factors such as poor blood circulation or nerve damage in the area.");
                     //Calling method to ask users if they want an at-home remedy
                            remedy = getRemedy ();

                    //If the user wants a remedy, we give it to them along with a brief description on how it helps
                            if (remedy == 'y' || remedy == 'Y')
                            {
                                c.println ("The best treatment for complete numbness is to");
                                c.setTextColor (Color.blue);
                                c.print("get it checked ");
                                c.setTextColor (Color.black);
                                c.print("as it is caused due to nerve damage or poor circulation. However, acupuncture is also a really helpful treatment for numbness as it improves the nervous system and blood circulation. Acupuncture includes the idea of inserting fine needles into the affected area. This treatment is often effective in treating numbness and has been around for thousands of years. ");
                                 //Closing message giving the user the option to get a rediagnosis, or book an appointment    
feedback = getFeedback ();
                            }
                        }

                //Depending on the symptom they select we give them an appropriate diagnosis
                        if (symptom == 3)
                        {
                    //Calling method to output diagnosis message
                            diagnosis ();
                    //Outputting the diagnosis and its brief description
                            c.setTextColor (Color.green);
                            c.println ("phantom limb ");
                            c.setTextColor (Color.black);
                    c.print("\nPhantom Limb is a type of neuropathic pain which is characterized by the feeling of pain in a limb that has been amputated. This happens due to the brain still continuing to sense 'pain' in the affected area due to the nerve sending signals to the brain. Individuals with this condition often experience feelings of itching, throbbing, or tingling in the amputated area. These symptoms often lead individuals to suffer immense emotional and physical distress.");
                    //Calling method to ask users if they want an at-home remedy
                            remedy = getRemedy ();

                    //If the user wants a remedy, we give it to them along with a brief description on how it helps
                            if (remedy == 'y' || remedy == 'Y')
                            {
                                c.setTextColor (Color.blue);
                                c.print("Massages");
                                c.setTextColor (Color.black);
                                c.print(" can be a really helpful remedy for those with phantom limb pain. It helps improve blood circulation and reduces any muscle tension in areas of pain. Massaging can include putting pressure or kneading the affected area. Another remedy that is really beneficial as well is warm compresses. Combining both massage and warm compresses helps reduce the pain signals from the nerves to the brain and also promotes relaxation.");
                        //Closing message giving the user the option to get a rediagnosis, or book an appointment
                                feedback = getFeedback ();
                            }
                        }
                    }
                }
        }
        c.getChar ();
    }

            //Booking an appointment section of the program
    public static void consultation ()
    {
        c.clear ();

        //Define variabes
        String name, number;
        char contact;
        int age, currentSize;
        currentSize = 0;
       //Define array size
        String[] patientList = new String [10];
        int[] ageList = new int [10];
        String[] phoneList = new String [10];
        //Introduction + Explanation
        c.setCursor (3, 5);
        c.println ("Booking an apointment is really easy! Based on your diagnosis results and symptoms, we have selected the perfect doctor just for you.");
        c.print ("\n\nNow we just need some of your personal information to set up an appointment. \n Name: ");
        name = c.readString ();

        //Add the name the user inputs into its array
        for (int x = 0 ; x < patientList.length ; x++)
        {
            patientList [x] = name;
        }

        //Ask user for their age
        c.print ("Age: ");
        age = c.readInt ();

        //Add the age the user inputs into its array
        for (int x = 0 ; x < ageList.length ; x++)
        {
            ageList [x] = age;
        }

        //Ask the user for their phone number
        c.print ("Phone number: ");
        number = c.readString ();

       //Add the phone number the user inputs into its array
        for (int x = 0 ; x < phoneList.length ; x++)
        {
            phoneList [x] = number;
        }

        //Ask user if they want to review their information
        c.println ("\nThank you for inputting your information, would you like to review your information? (y/n)");
        contact = c.readChar ();

        //If the user wants to review their information, provide them a list
        if (contact == 'y' || contact == 'Y')
        {
            c.clear ();
            c.println ("Here is your information:");
            c.println ("Name: " + name);
            c.println ("Age: " + age);
            c.println ("Phone number: " + number);
            c.println ("Thank you for booking an appointment with us! We will contact you soon.");
        }
        
         //Goodbye message
        if (contact == 'n' || contact == 'N')
        {
            c.println ("Thank you for booking an appointment with us " + name + "! We will contact you soon.");
        }
        
        c.getChar ();
    }

    //Cognitive test portion of our program
    public static void games ()
    {
        c.clear ();

       //Defining the variables
        int gameChoice, randomText, randomColor, score, guess, num, guessCount, x;
        char colorGame, numberGame;
        String text, textColor, awnser;
        //Initializing the variables
        x = 0;
        score = 0;

        //Defining the string containing the output color questions
        String[] colors = {"Red", "Blue", "Green", "Yellow", "Purple", };
        //Defining the string containing the potential colours that the text can be 
        String[] textColors = {"red", "blue", "green", "yellow", "purple", "orange" };

        //Outputting the introduction
        c.setTextColor (Color.blue);
        c.setCursor (3, 20);
        c.println (" ---- Welcome to the games section! ----");
        c.setTextColor (Color.black);
        c.println ("These games will test your cognitive abilities, and will help you improve your memory and problem solving skills! \n\n");
        c.println ("Would you like to test your... \n\n");
        //Giving the user the two game options
        c.println ("1. Visual abilities \n2. Problem Solving");
        gameChoice = c.readInt ();

        //If the user chooses 1, the following game will commence
        if (gameChoice == 1)
        {
            c.clear ();

        //Ouputting the introduction and explanation
            c.setTextColor (Color.blue);
            c.setCursor (3, 20);
            c.println ("Welcome to the Color Game! ");
            c.setTextColor (Color.black);
            c.println ("\n\nIn this game, you will be given a color, however the text of that color will be different. Your job is to correctly identify the COLOR OF THE TEXT, not the text itself. \n\n");
            c.print ("For example, if we give");
            c.setTextColor (Color.blue);
            c.print (" Red");
            c.setTextColor (Color.black);
            c.print (", the correct awnser is BLUE (which is the color of the text) not red. Please awnser the questions as quickly as possibe to keep the score results accurate. \n\nSo are you ready to play? (y/n)");
            colorGame = c.readChar ();

            if (colorGame == 'y' || colorGame == 'Y')
            {
                c.clear ();
                c.println ("Let's begin!\n\n");
        
            //For loop ensuring there is only 5 rounds of the game 
                for (x = 0 ; x < 5 ; x++)
                {
                //Randomly choosing a colour from the arrays
                    randomText = (int) (Math.random () * 4) + 0;
                    text = colors [randomText];
                    randomColor = (int) (Math.random () * 5) + 0;
                    textColor = textColors [randomColor];

                //if statements changing the colour of the text depending on the random colour chosen from the array
                    if (randomColor == 0)
                    {
                        c.setTextColor (Color.red);
                    }
                    else if (randomColor == 1)
                    {
                        c.setTextColor (Color.blue);
                    }
                    else if (randomColor == 2)
                    {
                        c.setTextColor (Color.green);
                    }
                    else if (randomColor == 3)
                    {
                        c.setTextColor (Color.yellow);
                    }
                    else if (randomColor == 4)
                    {
                        c.setTextColor (Color.magenta);
                    }
                    else if (randomColor == 5)
                    {
                        c.setTextColor(Color.orange);
                    }

                //Outputting the question
                    c.println (text);
                    c.setTextColor (Color.black);

                    c.println ("Your awnser: ");
                //Reading the users awnser
                    awnser = c.readString ();

                //If the answer is correct, output the correct message and add to their score
                    if (awnser.equalsIgnoreCase(textColor))
                    {
                        c.println ("Correct!");
                        c.println ("\n -------------------------------");
                        score++;
                    }
                    else
                    {
                //Output the error message and correct answer if the user is wrong
                        c.println ("Sorry your wrong. The correct answer is " + textColor);
                        c.println ("\n -------------------------------");
                    }
                }

                //After 5 rounds are over, reveal the users score out of 5
    c.println ("Your final score is " + score + " out of 5");
                c.println ("Thanks for playing!");
            }
        }

        //If the user chooses 2, commence the cognitive test game 
        if (gameChoice == 2)
        {
            c.clear ();

        //Output Introduction
            c.setTextColor (Color.blue);
            c.setCursor (3, 20);
            c.println ("Welcome to the Number Guessing Game! ");
            c.setTextColor (Color.black);

        //Output explanation
            c.println ("In this game, the we will choose a random number between 1 and 50. Your job is to guess the number in under five tries. Every time you guess the wrong number, we will give you a hint whether your guess was higher then the awnser, or lower. \n\nAre you ready to start! (y/n)");
            numberGame = c.readChar();

            if (numberGame == 'y' || numberGame == 'Y')
            {
                c.clear ();

             //Computer randomizes a number between 1 and 30
                num = (int) (Math.random () * 30) + 1;

            //Output Introduction
                c.println ("We have chosen our number!");
                c.println ("\n\nWhat is your guess?: ");
                guess = c.readInt ();

            //Invalid check, ensuring the users guess is between 1 and 30
                while (guess > 29 || guess < 1)
                {
                    c.println ("The number is between 1 and 30. Please guess again: ");
                    guess = c.readInt ();
                    x++;
                }
            //If the user guess higher than the actual number, tell them 
                while (guess > num && x < 5)
                {
                    c.println ("Your guess is too high!");
                    c.println ("Guess again: ");
                    guess = c.readInt ();
                    x++;
                }

            //If the user guess lower than the actual number, tell them
                while (guess < num && x < 5)
                {
                    c.println ("Your guess is too low!");
                    c.println ("Guess again: ");
                    guess = c.readInt ();
                    x++;
                } 

    //If the user guesses correctly, tell them a congratulations message
                if (guess == num && x < 5)
                {
                    c.setTextColor(Color.green);
                    c.println ("Congratulations! You guessed the number!");
                    c.setTextColor(Color.black);
                }

    //If the round counter is five, tell the user that they ran out of turns and reveal the correct awnser
                if (x == 5)
                {
                    c.println ("Sorry, ");
                    c.setTextColor(Color.red);
                    c.println("you ran out of guesses...");
                    c.setTextColor(Color.black);
                    c.println("The number was " + num);
                    c.println ("Thank you for playing!");
                }
            }
        }
        c.getChar ();
    }
}
