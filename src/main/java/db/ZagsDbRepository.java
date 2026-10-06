package db;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class ZagsDbRepository {

    private static final Logger log = LogManager.getLogger(ZagsDbRepository.class);

    private static final String FIND_ADMIN_BY_ID =
            "select * from reg_office.staff WHERE staffid = ?";
    private static final String FIND_CITIZEN_BY_ID =
            "select * from reg_office.citizens WHERE citizenid = ?";
    private static final String FIND_APPLICANT_BY_ID =
            "select * from reg_office.applicants WHERE applicantid = ?";
    private static final String FIND_APPLICATION_BY_ID =
            "select * from reg_office.applications WHERE applicationid = ?";
    private static final String FIND_BIRTHCERTIFICATE_BY_ID =
            "select * from reg_office.birthcertificates WHERE birthcertificateid = ?";
    private static final String FIND_DEATHCERTIFICATE_BY_ID =
            "select * from reg_office.deathcertificates WHERE deathcertificateid = ?";
    private static final String FIND_MERRIGECERTIFICATE_BY_ID =
            "select * from reg_office.merrigecertificates WHERE merrigecertificateid = ?";

    public Optional<DbRecord> findAdminById(long id) {
        return findOne(FIND_ADMIN_BY_ID, id);
    }

    public Optional<DbRecord> findClientById(long id) {
        return findOne(FIND_CITIZEN_BY_ID, id);
    }

    public Optional<DbRecord> findApplicantById(long id) {
        return findOne(FIND_APPLICANT_BY_ID, id);
    }

    public Optional<DbRecord> findApplicationById(long id) {
        return findOne(FIND_APPLICATION_BY_ID, id);
    }

    public Optional<DbRecord> findBirthCertificateById(long id) {
        return findOne(FIND_BIRTHCERTIFICATE_BY_ID, id);
    }

    public Optional<DbRecord> findDeathCertificateById(long id) {
        return findOne(FIND_DEATHCERTIFICATE_BY_ID, id);
    }

    public Optional<DbRecord> findMarriageCertificateById(long id) {
        return findOne(FIND_MERRIGECERTIFICATE_BY_ID, id);
    }

    private Optional<DbRecord> findOne(String sql, long param) {
        log.info("SQL: {} [{}]", sql, param);
        try (Connection c = DbConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, param);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    return Optional.empty();
                }
                DbRecord rec = new DbRecord();
                var meta = rs.getMetaData();
                for (int i = 1; i <= meta.getColumnCount(); i++) {
                    rec.put(meta.getColumnLabel(i).toLowerCase(), rs.getObject(i));
                }
                return Optional.of(rec);
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Ошибка выполнения SQL: " + sql, e);
        }
    }
}