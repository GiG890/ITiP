class Student extends Person {
        private String speciality;
        private int year; //курс
        private double score;

        public Student() {
            super();
            this.speciality="No";
            this.year=0;
            this.score=0.0;
        }

        public Student(String name, int age, String speciality, int year, double score) {
            super(name, age);
            this.speciality=speciality;
            this.year=year;
            this.score=score;
        }

        @Override
        public void work() {
            System.out.println(getName()+" is learning");
        }
        @Override
        public void status() {
            System.out.println(year+" year, speciality: "+speciality);
        }
        public void statud(){
            System.out.println(getName()+" is listed in the university");
        }

        public String getSpeciality() {return speciality;}
        public void setSpeciality(String speciality) {this.speciality=speciality;}

        public int getYear() {return year;}
        public void setYear(int year) {this.year=year;}

        public double getScore() {return score;}
        public void setScore(double score) {this.score=score;}
    }