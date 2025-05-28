package 회원정보;

public class Member {
    public enum Gender {
        MALE("남성"), FEMALE("여성");

        private final String displayName;

        Gender(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    public enum Job {
        STUDENT("학생"), OFFICE_WORKER("회사원"), HOUSEWIFE("주부"), UNEMPLOYED("무직");

        private final String displayName;

        Job(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    private final String name;
    private final int age;
    private final Gender gender;
    private final Job job;

    private Member(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.gender = builder.gender;
        this.job = builder.job;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public Job getJob() {
        return job;
    }

    public static class Builder {
        private String name;
        private int age;
        private Gender gender;
        private Job job;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            if (age < 0 || age > 199) {
                throw new IllegalArgumentException();
            }
            this.age = age;
            return this;
        }

        public Builder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Builder job(Job job) {
            this.job = job;
            return this;
        }

        public Member build() {
            if (name == null) {
                throw new IllegalStateException("Name must not be null");
            }
            if (gender == null) {
                throw new IllegalStateException("Gender must not be null");
            }
            if (job == null) {
                throw new IllegalStateException("Job must not be null");
            }
            return new Member(this);
        }
    }
}
