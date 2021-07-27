FROM postgres:9.4
RUN mkdir /sql
COPY *.sql /docker-entrypoint-initdb.d/
RUN psql -f /docker-entrypoint-initdb.d/create_user.sql
RUN psql -U postgres -W 123456 -f create_db.sql
RUN psql -U postgres -W 123456 -d school_ats -f create_tables.sql