package com.example.android3.data.entity.weather;

public class ForecastWeather {



        private String name;

        private String[] messages;

        private String blog;

        private String age;

        public String getName ()
        {
            return name;
        }

        public void setName (String name)
        {
            this.name = name;
        }

        public String[] getMessages ()
        {
            return messages;
        }

        public void setMessages (String[] messages)
        {
            this.messages = messages;
        }

        public String getBlog ()
        {
            return blog;
        }

        public void setBlog (String blog)
        {
            this.blog = blog;
        }

        public String getAge ()
        {
            return age;
        }

        public void setAge (String age)
        {
            this.age = age;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [name = "+name+", messages = "+messages+", blog = "+blog+", age = "+age+"]";
        }
    }

