public class Patient implements Comparable<Patient> {
    private String name;
    private String condition;
    private String priority;

    public Patient(String name, String condition, String priority) {
        this.name = name;
        this.condition = condition;
        this.priority = priority;
    }

    public String getName() { return name; }
    public String getCondition() { return condition; }
    public String getPriority() { return priority; }

    @Override
    public int compareTo(Patient other) {
        return this.priority.compareTo(other.priority);
    }

    @Override
    public String toString() {
        return name + " - " + condition + " (Prioridad: " + priority + ")";
    }
}

