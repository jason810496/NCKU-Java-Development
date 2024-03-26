# NCKU Java Development

## Setup

1. copy `template.env` to `.env` and replace `JUDGE_URL` with the real judge server url
```bash
cp template.env .env
# replace `JUDGE_URL` with the real judge server url
```

2. Replace `STUDENT_ID` with your student id in `Makefile`
```makefile
STUDENT_ID=YOUR_STUDENT_ID
```

## Usage
- Zip the homework folder
```bash
make zip HW=HW1 # switch to HW2, HW3 ... to zip other homework folder
# STUDENT_ID.zip will be generated
```
- Submit the zip file to Online Judge
```bash
make judge HW=HW1 # switch to HW2, HW3 ... to submit other homework
```