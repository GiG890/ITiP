class Teacher extends Person {
        private String subject;
        private int experience;
        private String faculty;

        public Teacher(){
            super();
            this.subject="No";
            this.experience=0;
            this.faculty="No";
        }

        public Teacher(String name, int age, String subject, int experience, String faculty) {
            super(name, age);
            this.subject=subject;
            this.experience=experience;
            this.faculty=faculty;
        }

        @Override
        public void work() {
            System.out.println(getName()+" teaches at the university.");
        }
        @Override
        public void status() {
            System.out.println(getName()+" teaches the "+subject+" years of"+experience);
        }
        
        public void teaching() {
            System.out.println(getName()+" teaches teaches from the department "+ faculty);
        }


    }
