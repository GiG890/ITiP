class Assistant extends Person {
        private String affiliation;
        private int scopeOfWork;
        
        public Assistant() {
            super();
            this.affiliation="employee";
            this.scopeOfWork=0;
        }

        public Assistant(String name, int age, String affiliation, int scopeOfWork) {
            super(name, age);
            this.affiliation=affiliation;
            this.scopeOfWork=scopeOfWork;
        }

        @Override
        public void work() {
            System.out.println(getName()+" is assistant");
        }
        @Override
        public void status() {
            System.out.println(getName()+" belongs to the "+affiliation+" and works "+scopeOfWork+" hours.");
        }
        public void sprcificWork() {
            System.out.println(getName()+" has made progress in the field of "+ affiliation);
        }
        public int getScopeOfWork() {return scopeOfWork;}
        public void setScopeOfWork(int scopeOfWork) {
            if (scopeOfWork>=0) this.scopeOfWork=scopeOfWork;


    }
}
