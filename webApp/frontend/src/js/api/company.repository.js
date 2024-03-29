import { handleError } from './handleErrors.service';

export default class CompanyRepository {
    constructor(store) {
        this.store = store;
    }


    getHeaders = () => {
        return {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${this.store.getState().JWT}`,
        };
    }

    addUserToCompany = (userId, role) => {
        return fetch(`http://localhost:8090/company/${this.store.getState().companyWorkingFor.id}`, {
            method: 'POST',
            headers: this.getHeaders(),
            body: JSON.stringify({ userId, companyRole: role.toUpperCase() }),
        })
            .then(response => handleError(response))
            .catch(err => console.warn("Caught error while trying to add member to company. ", err));
    }

    createMemberToCompany = user => {
        return fetch(`http://localhost:8090/user/member`, {
            method: 'POST',
            headers: this.getHeaders(),
            body: JSON.stringify({
                ...user,
                companyRole: user.role.toUpperCase(),
                companyId: this.store.getState().companyWorkingFor.id,
            }),
        })
            .then(response => handleError(response))
            .catch(err => console.warn("Caught error while trying to create member for company. ", err));
    }
}