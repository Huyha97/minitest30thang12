public class Student extends Human{
    private double MathPoint;
    private double PhyPoint;
    private double ChemPoint;


    public Student(int id, String name, int age, double mathPoint, double phyPoint, double chemPoint) {
        super(id, name, age);
        MathPoint = mathPoint;
        PhyPoint = phyPoint;
        ChemPoint = chemPoint;
    }

    public double getMathPoint() {
        return MathPoint;
    }

    public void setMathPoint(double mathPoint) {
        MathPoint = mathPoint;
    }

    public double getPhyPoint() {
        return PhyPoint;
    }

    public void setPhyPoint(double phyPoint) {
        PhyPoint = phyPoint;
    }

    public double getChemPoint() {
        return ChemPoint;
    }

    public void setChemPoint(double chemPoint) {
        ChemPoint = chemPoint;
    }
    public double getAvgPoint(){
        return (MathPoint + PhyPoint+ChemPoint)/3;
    }

    @Override
    public String toString() {
        return "Student{" + super.toString() +
                "MathPoint=" + MathPoint +
                ", PhyPoint=" + PhyPoint +
                ", ChemPoint=" + ChemPoint +
                '}';
    }
}
